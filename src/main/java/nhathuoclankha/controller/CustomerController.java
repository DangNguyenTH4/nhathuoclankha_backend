package nhathuoclankha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.dto.CustomerDto;
import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
@Slf4j
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  private final String PHONE = "PHONE";
  private final String NAME_ = "NAME_";
  private final String FARM_ = "FARM_";

  @GetMapping("/findByPhone")
  public CustomerDto findCustomerByPhone(@RequestParam String phone) {
    return customerService.findCustomerByPhone(phone);
  }

  @GetMapping(value = "findLikePhone")
  public List<CustomerDto> findLikeCustomerLikePhone(@RequestParam String phone) {
    return customerService.findCustomerLikePhone(phone);
  }

  @GetMapping(value = "list-phone")
  public List<String> getListPhone(@RequestParam String phone) {
    return customerService.getListPhone(phone);
  }

  @GetMapping(value = "list-name")
  public List<String> getListName(@RequestParam String name) {
    return customerService.getListName(name);
  }
  @GetMapping(value = "list-farm-name")
  public List<String> getListFarmName(@RequestParam String name) {
    return customerService.getListFarmName(name);
  }

  @GetMapping(value = "get-list-bought")
  public List<MedicineDto> getListBougthBy(@RequestParam String phone) {
    List<MedicineDto> result = null;
    if (!StringUtils.isEmpty(phone)) {
      if (phone.startsWith(PHONE)) {
        log.info(">>> get-list-bought - startwith: "+PHONE);
        phone = phone.substring(5).trim();
        result = customerService.getListBougthByPhone(phone);
      } else if (phone.startsWith(NAME_)) {
        log.info(">>> get-list-bought - startwith: "+NAME_);
        phone = phone.substring(5).trim();
        result = customerService.getListBougthByName(phone);
      }
      else if (phone.startsWith(FARM_)) {
        log.info(">>> get-list-bought - startwith: "+FARM_);
        phone = phone.substring(5).trim();
        //Client gửi lên sẽ là số điện thoại của customer, nếu không tìm thấy thì là blank.
        result = customerService.getListBougthByFarmName(phone);
      }

    }
    return result;
  }

  @GetMapping(value = "get-customer")
  public CustomerDto getCustomerBy(@RequestParam String phone) {
    CustomerDto cus = null;
    if (!StringUtils.isEmpty(phone)) {
      if (phone.startsWith(PHONE)) {
        log.info(">>>getCustomerBy - start with:  " + PHONE);
        phone = phone.substring(5).trim();
        cus = customerService.getLastestCustomerByPhone(phone);
      } else if (phone.startsWith(NAME_)) {
        log.info(">>>getCustomerBy - start with:  " + NAME_);
        phone = phone.substring(5).trim();
        cus = customerService.getLastestCustomerByName(phone);
      }
      else if(phone.startsWith(FARM_)){
        log.info(">>> get customer by farm name.");
        phone = phone.substring(5).trim();
        cus = customerService.getLastestCustomerByFarmName(phone);
      }
    }
    return cus;
  }
}
