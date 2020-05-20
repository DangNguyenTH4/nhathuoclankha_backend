package nhathuoclankha.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import nhathuoclankha.auth.model.UserDetailCustom;
import nhathuoclankha.model.Price;
import nhathuoclankha.utils.AppConstants.MedicineMessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.auth.service.SecurityService;
import nhathuoclankha.dto.ImportOrderDto;
import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.exceptions.EmptyException;
import nhathuoclankha.mapper.ImportOrderMapper;
import nhathuoclankha.mapper.MedicineMapper;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.model.ImportOrderDetail;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.repository.ImportOrderDetailRepository;
import nhathuoclankha.repository.ImportOrderRepository;
import nhathuoclankha.repository.ImportOrderRepositoryCustomer;
import nhathuoclankha.utils.DateUtils;

@Service
@Slf4j
public class ImportOrderService {

  @Autowired
  private ImportOrderRepository importOrderRepository;
  @Autowired
  private ImportOrderRepositoryCustomer importOrderRepositoryCustomer;
  @Autowired
  private MedicineService medicineService;
  @Autowired
  private ImportOrderMapper importOrderMapper;
  @Autowired
  private MedicineMapper medicineMapper;
  @Autowired
  private PriceService priceService;

  @Autowired
  private SecurityService securityService;

  @Autowired
  private ImportOrderDetailRepository importOrderDetailRepository;

  /**
   *
   * @param importOrderDto
   * @return
   */
  @Transactional
  public ImportOrderDto importOrder(ImportOrderDto importOrderDto) {
    log.info(">>> Import order processing ...");
    List<MedicineDto> listMedicineDto = importOrderDto.getListMedicineImport();
    if (listMedicineDto == null || listMedicineDto.size() == 0) {
      throw new EmptyException(MedicineMessageConstants.EMPTY_LIST_MEDICINE);
    }
    ImportOrder importOrder = importOrderMapper.toEntity(importOrderDto);
    //Get user name: from jwt token
    String username = securityService.getUserName();
    log.info(">>> client user : {}, serveruser: {}", importOrder.getStaffName(), username);
    UserDetailCustom user = (UserDetailCustom) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
    importOrder.setStaffName(user.getUsername());

    if (importOrder.getImportDate() == null) {
      importOrder.setImportDate(Instant.now());
    }
    //Save import order overview
    importOrder = importOrderRepository.save(importOrder);

    List<ImportOrderDetail> listImportOrderDetail = new ArrayList<ImportOrderDetail>();
    for (MedicineDto medicineDto : listMedicineDto) {
      // Update quantity total and new price
      Medicine m = medicineService.updateQuantityExistingAndNewPriceWhenImport(medicineDto);


      // Create import order detail
      ImportOrderDetail importOrderDetail = new ImportOrderDetail();
      importOrderDetail.setAmount(medicineDto.getAmount());
      importOrderDetail.setExpiryDate(medicineDto.getExpiryDate());
      importOrderDetail.setPrice(m.getPrice());

      if (importOrderDto.getImportDate() == null) {
        importOrderDetail.setDateImport(Instant.now());
      }
      importOrderDetail.setMedicine(m);
      importOrderDetail.setImportOrder(importOrder);
      importOrderDetail.getImportOrderDetailKey().setMedicineId(m.getId());
      importOrderDetail.getImportOrderDetailKey().setImportOrderId(importOrder.getId());
//      importOrderDetail.setPriceId(m.getPrice().getId());

      listImportOrderDetail.add(importOrderDetail);

    }
    importOrderRepository.save(importOrder);
    listImportOrderDetail = importOrderDetailRepository.saveAll(listImportOrderDetail);
    importOrderDto = importOrderMapper.toDto(importOrder);
    return importOrderDto;
  }

  /**
   * history import order.
   * @param fromDate
   * @param toDate
   * @return
   */
  public List<ImportOrderDto> getHistoryImportOrder(String fromDate, String toDate) {
    Instant from = DateUtils.getInstantDateQuery(fromDate);
    Instant to = DateUtils.getInstantDateQuery(toDate);
    List<ImportOrderDto> resultList = new ArrayList<>();
    // get List import order
    List<ImportOrder> listImportOrder =
        importOrderRepositoryCustomer.findImportOrderBetween(from, to);
    for (ImportOrder io : listImportOrder) {
      ImportOrderDto dto = new ImportOrderDto();
      dto = importOrderMapper.toDto(io);
      List<MedicineDto> listMedicineDto = new ArrayList<>();
      // find import order detail by import order id
//      List<ImportOrderDetail> importOrderDetailList =
//          importOrderDetailRepository.findByImportOrder(io);
      List<ImportOrderDetail> importOrderDetailList =
          importOrderDetailRepository.findByImportOrderByOrderByMedicineCode(io.getId());

      for (ImportOrderDetail iod : importOrderDetailList) {
        MedicineDto medicineDto = medicineMapper.toDto(iod.getMedicine());
        medicineDto.setAmount(iod.getAmount());
        medicineDto.setRealSellPrice(0.0);
        listMedicineDto.add(medicineDto);
      }
      dto.setListMedicineImport(listMedicineDto);
      // Add import order dto to list and response
      resultList.add(dto);
    }

    return resultList;
  }


}
