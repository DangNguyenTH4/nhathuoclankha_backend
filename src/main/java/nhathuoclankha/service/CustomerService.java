package nhathuoclankha.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import nhathuoclankha.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import nhathuoclankha.dto.CustomerDto;
import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.mapper.CustomerMapper;
import nhathuoclankha.mapper.MedicineMapper;
import nhathuoclankha.model.Customer;
import nhathuoclankha.model.SellOrder;
import nhathuoclankha.model.SellOrderDetail;
import nhathuoclankha.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private CustomerMapper customerMapper;
  @Autowired
  private SellMedicineService sellMedicineService;
  @Autowired
  private MedicineMapper medicineMapper;
  @Autowired
  private MedicineService medicineService;

  public CustomerDto findCustomerByPhone(String phone) {
    List<Customer> listCus = customerRepository.findByPhoneNumber(phone);
    Customer cus = null;
    if (listCus != null && listCus.size() != 0) {
      cus = listCus.get(0);
    }
    CustomerDto dto = customerMapper.toDto(cus);
    return dto;
  }

  public List<CustomerDto> findCustomerLikePhone(String phone) {
    List<Customer> listCus = null;
    if (StringUtils.isEmpty(phone)) {
      listCus = customerRepository.findAll();
    } else {
      listCus = customerRepository.findDistinctByPhoneNumberIsContaining(phone);
    }
    List<CustomerDto> listDto = customerMapper.toListDto(listCus);
    return listDto;
  }


  public List<MedicineDto> getListBougthByName(String name) {
    List<MedicineDto> listResult = null;
    if (StringUtils.isEmpty(name)) {
      return medicineService.getGetAllOrderByMedicineName();
    }
    // Tìm customer theo số điện thoại, có thể trùng nhau=> Lấy số điện cus lastest
    List<Customer> cus = customerRepository.findByName(name);
    if (cus != null && cus.size() != 0) {
      // Lấy ra danh sách các order mà số này đã mua. sắp xếp theo thời gian từ gần
      // tới xa
      List<SellOrder> listSellOrderBought =
          sellMedicineService.getListSellOrderByCustomerDescTime(cus.get(cus.size() - 1));
      // Lấy ra danh sách các detail của order sắp xếp the thời gian từ gần tới xa.
      List<SellOrderDetail> listSellOrderDetail =
          sellMedicineService.getListSellOrderDetailByListSellOrder(listSellOrderBought);
      listResult = this.initListMedicineBoughtFromSellOrderDetail(listSellOrderDetail);
      listResult = this.mergeListMedicineBoughtToMedicineSource(listResult);
    } else {
      listResult = medicineService.getGetAllOrderByMedicineName();
    }
    return listResult;

  }

  public List<MedicineDto> getListBougthByFarmName(String farmName) {
    List<MedicineDto> listResult = null;
    if (StringUtils.isEmpty(farmName)) {
      return medicineService.getGetAllOrderByMedicineName();
    }
    // Tìm customer theo số điện thoại, có thể trùng nhau=> Lấy số điện cus lastest
    Customer cus = customerRepository.findTop1ByTraiDungThuocOrderByIdDesc(farmName);
    if (cus != null ) {
      // Lấy ra danh sách các order mà số này đã mua. sắp xếp theo thời gian từ gần
      // tới xa
      List<SellOrder> listSellOrderBought =
          sellMedicineService.getListSellOrderByCustomerDescTime(cus);
      // Lấy ra danh sách các detail của order sắp xếp the thời gian từ gần tới xa.
      List<SellOrderDetail> listSellOrderDetail =
          sellMedicineService.getListSellOrderDetailByListSellOrder(listSellOrderBought);
      listResult = this.initListMedicineBoughtFromSellOrderDetail(listSellOrderDetail);
      listResult = this.mergeListMedicineBoughtToMedicineSource(listResult);
    } else {
      listResult = medicineService.getGetAllOrderByMedicineName();
    }
    return listResult;

  }

  /**
   *
   * @param listSellOrderDetail
   * @return
   */
  private List<MedicineDto> initListMedicineBoughtFromSellOrderDetail(
      List<SellOrderDetail> listSellOrderDetail) {
    List<MedicineDto> listResult = new ArrayList<>();
    MedicineDto dto = null;
    // Make List Medicine Dto
    for (SellOrderDetail detail : listSellOrderDetail) {
      if (detail.getTime() != null) {
        dto = medicineMapper.toDto(detail.getMedicine());
        if (dto != null) {
          if (!listResult.contains(dto)) {
            dto.setRealSellPrice(detail.getRealSellPrice());
            listResult.add(dto);
          }
        }
      }
    }
    return listResult;
  }

  /**
   * Update những loại thuốc có mua vào danh sách thuốc rồi trả về cho client.
   *
   * @param listResult
   * @return
   */
  private List<MedicineDto> mergeListMedicineBoughtToMedicineSource(List<MedicineDto> listResult) {
    List<MedicineDto> listMedicineDtoSource = medicineService.getGetAllOrderByMedicineName();
    if (CommonUtils.isCollectionEmpty(listMedicineDtoSource) && CommonUtils
        .isCollectionEmpty(listResult)) {
      for (MedicineDto dtoResult : listResult) {
        for (int i = 0; i < listMedicineDtoSource.size(); i++) {
          if (listMedicineDtoSource.get(i).equals(dtoResult)) {
            listMedicineDtoSource.set(i, dtoResult);
            break;
          }
        }
      }
    }
    return listMedicineDtoSource;
  }
  /**
   * getListBougthByFarmName
   */

  /***
   * Lấy ra danh sách những thuốc đã mua, nếu mua 1 loại nhiều lần thì lấy lần gần nhất.
   *
   * @param phone
   * @return
   */
  public List<MedicineDto> getListBougthByPhone(String phone) {
    List<MedicineDto> listResult = null;
    // Nếu số điện thoại null hoặc trống thì k cần tìm nữa
    if (StringUtils.isEmpty(phone)) {
      return medicineService.getGetAllOrderByMedicineName();
    }
    // Tìm customer theo số điện thoại, có thể trùng nhau=> Lấy số điện cus lastest
    List<Customer> cus = customerRepository.findByPhoneNumber(phone);
    if (cus != null && cus.size() != 0) {
      listResult = this.getListMedicineLastestCustomerBought(cus.get(cus.size() - 1));
    } else {
      listResult = medicineService.getGetAllOrderByMedicineName();
    }
    return listResult;
  }

  public List<MedicineDto> getListMedicineLastestCustomerBought(Customer customer){
    List<MedicineDto> listResult = null;
    // Lấy ra danh sách các order mà số này đã mua. sắp xếp theo thời gian từ gần
    // tới xa
    List<SellOrder> listSellOrderBought =
        sellMedicineService.getListSellOrderByCustomerDescTime(customer);
    // Lấy ra danh sách các detail của order sắp xếp the thời gian từ gần tới xa.
    List<SellOrderDetail> listSellOrderDetail =
        sellMedicineService.getListSellOrderDetailByListSellOrder(listSellOrderBought);
    listResult = this.initListMedicineBoughtFromSellOrderDetail(listSellOrderDetail);
    // Update những loại thuốc có mua vào danh sách thuốc rồi trả về cho client
    listResult = this.mergeListMedicineBoughtToMedicineSource(listResult);
    return listResult;
  }

  /**
   * Get list distinct all customer name.
   *
   * @param name
   * @return
   */
  public List<String> getListName(String name) {
    List<String> listName = null;
    if (StringUtils.isEmpty(name)) {
      name = "%%";
    } else {
      name = "%" + name + "%";
    }
    listName = customerRepository.findListName(name);
    return listName;
  }

  /**
   * @param name
   * @return
   */
  public List<String> getListFarmName(String name) {
    List<String> listName = null;
    if (StringUtils.isEmpty(name)) {
      name = "%%";
    } else {
      name = "%" + name + "%";
    }
    listName = customerRepository.findListFarmName(name);
    return listName;
  }

  /**
   * Get list distinct all customer phone.
   *
   * @param phone
   * @return
   */
  public List<String> getListPhone(String phone) {
    List<String> listPhone = null;
    if (StringUtils.isEmpty(phone)) {
      phone = "%%";
    } else {
      phone = "%" + phone + "%";
    }
    listPhone = customerRepository.findListPhoneNumber(phone);
    return listPhone;
  }


  /**
   * @param name
   * @return
   */
  public CustomerDto getLastestCustomerByName(String name) {
    if (StringUtils.isEmpty(name)) {
      return new CustomerDto();
    }
    List<Customer> list = customerRepository.findByName(name);
    if (list == null || list.size() == 0) {
      return null;
    }
    Customer cus = list.get(list.size() - 1);
    return customerMapper.toDto(cus);
  }

  public CustomerDto getLastestCustomerByPhone(String phone) {
    if (StringUtils.isEmpty(phone)) {
      return new CustomerDto();
    }
    List<Customer> list = customerRepository.findByPhoneNumber(phone);
    if (list == null || list.size() == 0) {
      return null;
    }
    Customer cus = list.get(list.size() - 1);
    return customerMapper.toDto(cus);
  }

  /**
   * @param famrName
   * @return
   */
  public CustomerDto getLastestCustomerByFarmName(String famrName) {
    if (StringUtils.isEmpty(famrName)) {
      return new CustomerDto();
    }
    Customer list = customerRepository.findTop1ByTraiDungThuocOrderByIdDesc(famrName);
    if (list == null ) {
      return null;
    }
    Customer cus = list;
    return customerMapper.toDto(cus);
  }

  /**
   * (1).Tìm theo id nếu tồn tại trả về customer đó, không làm gì cả. (2)Nếu tìm theo id không có,
   * tìm theo số điên thoại, nếu có thì update thông tin của customer đó, Nêu không tìm thấy theo 2
   * điều kiện trên thì tạo customer mới, Trường Name và trại dùng thuốc để là khách mua lẻ, nếu
   * trống
   *
   * @param customer
   * @return
   */
  public Customer createOrUpdateCustomer(Customer customer) {
    if (customer != null) {
      if (customer.getId() != null) {
        Optional<Customer> getCustomerById = customerRepository
            .findById(customer.getId());
        //(1)Tìm theo id nếu tồn tại trả về customer đó, không làm gì cả.
        if (getCustomerById.isPresent()) {
          return getCustomerById.get();
        }
      }
      //(2)Nếu tìm theo id không có, tìm theo số điên thoại, nếu có thì update thông tin của customer đó,
      List<Customer> customers = customerRepository
          .findByPhoneNumber(customer.getPhoneNumber());
      if (customers != null && customers.size() != 0) {
        // Get the lastest customer with the phone.
        Customer oldCustomer = customers.get(customers.size() - 1);
        customer.setId(oldCustomer.getId());
        customerRepository.save(customer);
      } else {
        //Create new Customer
        // if no name, or no phone or ...
        if (StringUtils.isEmpty(customer.getName())
            && StringUtils.isEmpty(customer.getPhoneNumber())
          // .... add more later TOTO : for what???
        ) {
          if (StringUtils.isEmpty(customer.getName())) {
            customer.setName("Khách lẻ");
          }
          if (StringUtils.isEmpty(customer.getTraiDungThuoc())) {
            customer.setTraiDungThuoc("Khách lẻ");
          }
        }
        customer.setId(null);
        customer = customerRepository.save(customer);
      }

    }
    return customer;
  }


}
