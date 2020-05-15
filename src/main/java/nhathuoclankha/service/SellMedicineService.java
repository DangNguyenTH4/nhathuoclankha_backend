package nhathuoclankha.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import nhathuoclankha.dto.InvoiceDto;
import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.dto.SellOrderDto;
import nhathuoclankha.exceptions.EmptyException;
import nhathuoclankha.exceptions.NotSupportAnyMoreException;
import nhathuoclankha.mapper.SellOrderMapper;
import nhathuoclankha.model.Customer;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.model.SellOrder;
import nhathuoclankha.model.SellOrderDetail;
import nhathuoclankha.repository.CustomerRepository;
import nhathuoclankha.repository.SellOrderDetailRepository;
import nhathuoclankha.repository.SellOrderRepository;
import nhathuoclankha.repository.custom.SellOrderDetailRepositoryCustom;
import nhathuoclankha.utils.DateUtils;

@Service
public class SellMedicineService {
	@Autowired
	private SellOrderRepository sellOrderRepository;
	@Autowired
	private SellOrderDetailRepository sellOrderDetailRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private SellOrderMapper sellOrderMapper;
	@Autowired
	private SellOrderDetailRepositoryCustom sellOrderDetailRepositoryCustom;

	private Logger logger = LoggerFactory.getLogger(SellMedicineService.class);

	/**
	 * Tạo hóa đơn bán hàng.
	 * 
	 * @param sellOrderDto
	 * @return
	 */
	@Transactional
	public SellOrderDto createSellOrder(SellOrderDto sellOrderDto) {
		Set<MedicineDto> listMedicineDto = sellOrderDto.getListMedicines();
		if (listMedicineDto == null || listMedicineDto.size() == 0) {
			throw new EmptyException("Không có thuốc nào trong đơn hàng!");
		}
		SellOrder sellOrder = sellOrderMapper.toEntity(sellOrderDto);
		// Set total to 0
		Long totalFromClient = sellOrder.getTotal();
		sellOrder.setTotal(0L);

		if (sellOrder.getCustomer() != null) {
			if(sellOrder.getCustomer().getId()!=null){
				Optional<Customer> getCustomerById = customerRepository.findById(sellOrder.getCustomer().getId());
			}
			// Find customer by phone. 0
			List<Customer> customers = customerRepository.findByPhoneNumber(sellOrder.getCustomer().getPhoneNumber());
			if (customers != null && customers.size() != 0) {
				// Get the lastest customer with the phone.
				sellOrder.setCustomer(customers.get(customers.size() - 1));
			} else {
				// if no name, or no phone or ...
				if (StringUtils.isEmpty(sellOrder.getCustomer().getName())
						|| StringUtils.isEmpty(sellOrder.getCustomer().getPhoneNumber())
				// .... add more later TOTO : for what???
				) {
					if (StringUtils.isEmpty(sellOrder.getCustomer().getName())) {
						sellOrder.getCustomer().setName("Khách lẻ");
						sellOrder.getCustomer().setId(null);

					}
				}
				Customer cus = customerRepository.save(sellOrder.getCustomer());
				sellOrder.setCustomer(cus);
			}

		}
		// Save import order
		sellOrder.setTime(Instant.now());
		sellOrder = sellOrderRepository.save(sellOrder);
		System.out.println(sellOrder.getId());
		// Save Import Order Detail
		List<SellOrderDetail> listSellOrderDetail = new ArrayList<SellOrderDetail>();

		for (MedicineDto medicineDto : listMedicineDto) {
			// Update amount existing
			Medicine m = medicineService.updateQuantityExsitingWhenSell(medicineDto);
			// Create sellORder detail
			SellOrderDetail sellOrderDetail = new SellOrderDetail();
			sellOrderDetail.setAmount(medicineDto.getAmount());
			sellOrderDetail.setAddMore(medicineDto.getAddMore());
			sellOrderDetail.setMedicine(m);
			sellOrderDetail.setSellOrder(sellOrder);
			sellOrderDetail.setPriceId(m.getPrice().getId());
			sellOrderDetail.setTime(Instant.now());
			listSellOrderDetail.add(sellOrderDetail);

			if (sellOrder.getCustomer() != null) {
				if ("company".equals(sellOrder.getCustomer().getType())) {
					long temp = sellOrder.getTotal()
							+ this.calculateTotalOfMedicine(m.getPrice().getSellForCompanyPrice(),
									sellOrderDetail.getAddMore(), medicineDto.getAmount());
					sellOrder.setTotal(temp);
					sellOrderDetail.setPriceSell(m.getPrice().getSellForCompanyPrice());

				} else if ("farm".equals(sellOrder.getCustomer().getType())) {
					long temp = sellOrder.getTotal() + this.calculateTotalOfMedicine(m.getPrice().getSellForFarmPrice(),
							sellOrderDetail.getAddMore(), medicineDto.getAmount());
					sellOrder.setTotal(temp);

					sellOrderDetail.setPriceSell(m.getPrice().getSellForFarmPrice());
				} else {
					long temp = sellOrder.getTotal()
							+ this.calculateTotalOfMedicine(m.getPrice().getSellForPersonalPrice(),
									sellOrderDetail.getAddMore(), medicineDto.getAmount());

					sellOrder.setTotal(temp);
					sellOrderDetail.setPriceSell(m.getPrice().getSellForPersonalPrice());
				}
			}
			// But need to test => show i put two case. Then need to remove
			else {
				long temp = sellOrder.getTotal() + this.calculateTotalOfMedicine(m.getPrice().getSellForPersonalPrice(),
						sellOrderDetail.getAddMore(), medicineDto.getAmount());

				sellOrder.setTotal(temp);
				sellOrderDetail.setPriceSell(m.getPrice().getSellForPersonalPrice());
			}

		}
		if (totalFromClient != sellOrder.getTotal()) {
			logger.warn("Total from client different from server: Client: " + totalFromClient + " Server: "
					+ sellOrder.getTotal());
		}
		sellOrderRepository.save(sellOrder);
		// sellOrder.setId(newOrder.getId());
		sellOrderDetailRepository.saveAll(listSellOrderDetail);

		sellOrderDto = sellOrderMapper.toDto(sellOrder);

		return sellOrderDto;
	}

	private Long calculateTotalOfMedicine(Long price, Long addMore, Integer amount) {
		return (price + addMore) * amount;
	}

	/**
	 * Lấy ra danh sách các order đã bán cho một khách hàng nào đó, sắp xếp theo
	 * thời gian giảm dần.
	 * 
	 * @param cus
	 * @return
	 */
	public List<SellOrder> getListSellOrderByCustomerDescTime(Customer cus) {
		if (cus == null) {
			return null;
		}
		List<SellOrder> listOrder = null;
		listOrder = sellOrderRepository.findByCustomerOrderByTimeDesc(cus);
		return listOrder;
	}

	public List<SellOrderDetail> getListSellOrderDetailByListSellOrder(List<SellOrder> list) {
		List<SellOrderDetail> listResult = null;

		listResult = sellOrderDetailRepository.findBySellorderInOrderByTimeDesc(list);

		return listResult;
	}

	/**
	 * get history sell.
	 * 
	 * @param fromDate DateTimeFormatter.ISO_INSTANT
	 * @param toDate   DateTimeFormatter.ISO_INSTANT
	 * @return
	 */
	public List<SellOrderDto> getHistorySell(String fromDate, String toDate) {

		Instant from = DateUtils.getInstantDateQuery(fromDate);
		Instant to = DateUtils.getInstantDateQuery(toDate);

		List<SellOrder> listSellOrder = sellOrderRepository.findByTimeBetween(from, to);
		List<SellOrderDto> listSellOrderDto = sellOrderMapper.toListDto(listSellOrder);
		return listSellOrderDto;
	}

	/**
	 * getHistorySell. if staffName is null => find by all staff, (Only for admin
	 * user)
	 * 
	 * @param staffName
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public List<SellOrderDto> getHistorySell(String staffName, String fromDate, String toDate) {
		if (StringUtils.isEmpty(staffName)) {
			return this.getHistorySell(fromDate, toDate);
		}
		// When staffName != null or != empty : find a Sell history of specific staff
		Instant from = DateUtils.getInstantDateQuery(fromDate);
		Instant to = DateUtils.getInstantDateQuery(toDate);

		List<SellOrder> listSellOrder = sellOrderRepository.findBySellerAndTimeBetween(staffName, from, to);
		List<SellOrderDto> listSellOrderDto = sellOrderMapper.toListDto(listSellOrder);
		return listSellOrderDto;
	}

	/**
	 * getHistorySell in to day. if staffName is null => find by all staff, (Only
	 * for admin user)
	 * 
	 * @param staffName
	 * @return
	 */
	public List<SellOrderDto> getHistorySell(String staffName) {
		Instant from = DateUtils.getTodayInstant(Boolean.TRUE);
		Instant to = DateUtils.getTodayInstant(Boolean.FALSE);
		List<SellOrder> listSellOrder = null;
		if (StringUtils.isEmpty(staffName)) {
			listSellOrder = sellOrderRepository.findByTimeBetween(from, to);
		} else {
			listSellOrder = sellOrderRepository.findBySellerAndTimeBetween(staffName, from, to);
		}

		List<SellOrderDto> listSellOrderDto = sellOrderMapper.toListDto(listSellOrder);
		for (SellOrderDto sodto : listSellOrderDto) {
			List<InvoiceDto> list = this.getListSellOrderDetailBySellOrder(sodto.getId());
			sodto.setListInvoice(list);
		}
		return listSellOrderDto;
	}

	/**
	 * Lấy ra hóa đơn bán hàng chi tiết các loại thuốc, theo Mã hóa đơn. (Invoice)
	 * 
	 * @param sellOrderId
	 * @return
	 */
	public SellOrderDto getHistorySell(Integer sellOrderId) {
		Optional<SellOrder> order = sellOrderRepository.findById(sellOrderId);
		SellOrderDto dto = null;
		if (order.isPresent()) {
			SellOrder entity = order.get();
			dto = sellOrderMapper.toDto(entity);
			List<InvoiceDto> invoices = this.getListSellOrderDetailBySellOrder(entity.getId());
			dto.setListInvoice(invoices);
		}
		return dto;
	}

	/**
	 * Lấy ra danh sách các thuốc theo mã hóa đơn.
	 * 
	 * @param so
	 * @return
	 */
	private List<InvoiceDto> getListSellOrderDetailBySellOrder(int so) {

		return sellOrderDetailRepositoryCustom.getInvoiceDto(so);
	}

	/**
	 * Lấy ra chi tiết các hóa đơn, có search theo parameter truyền vào
	 * 
	 * @param parameters
	 * @param fromDate
	 * @param toDate
	 * @throws NotSupportAnyMoreException 
	 */
	public List<SellOrderDto> getDetailHistorySell(String parameters, String fromDate, String toDate) throws NotSupportAnyMoreException {
		if(!StringUtils.isEmpty(parameters)) {
			throw new NotSupportAnyMoreException("Chi tiết bán hàng có tham số chưa được hỗ trợ.");
		}
		
		List<SellOrderDto> listResult = null;
		Instant from = DateUtils.getInstantDateQuery(fromDate);
		Instant to = DateUtils.getInstantDateQuery(toDate);
		List<SellOrder> listSellOrder = sellOrderRepository.findByTimeBetween(from, to);
		List<SellOrderDetail> detailList = this.getListSellOrderDetailByListSellOrder(listSellOrder);
		
		listResult = sellOrderMapper.toListDto(listSellOrder);
		for(SellOrderDetail dto :detailList) {
			
		}
		return listResult;
	}
}
