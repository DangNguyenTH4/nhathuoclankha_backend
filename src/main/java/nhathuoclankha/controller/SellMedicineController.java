package nhathuoclankha.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nhathuoclankha.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nhathuoclankha.auth.model.UserDetailCustom;
import nhathuoclankha.dto.SellOrderDto;
import nhathuoclankha.exceptions.NotSupportAnyMoreException;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.model.Price;
import nhathuoclankha.model.SellOrder;
import nhathuoclankha.repository.MedicineRepository;
import nhathuoclankha.repository.PriceRepository;
import nhathuoclankha.service.SellMedicineService;

@RequestMapping("/sell-medicine")
@RestController
public class SellMedicineController {

  @Autowired
  private SellMedicineService sellMedicineService;
  @Autowired
  private MedicineRepository medicineRepository;
  @Autowired
  private PriceRepository priceRepository;



  /***
   *
   * @return
   */
  @RequestMapping(value = "/sell", method = RequestMethod.POST)
  public SellOrderDto createSellOrder(@RequestBody SellOrderDto sellOrderDto) {
    sellOrderDto = sellMedicineService.createSellOrder(sellOrderDto);
    return sellOrderDto;
  }

  @RequestMapping(value = "/sell", method = RequestMethod.GET)
  public String createSellOrder1() {
    return "Lam gi vay!";
  }

  @RequestMapping(value = "/myhistory-sell", method = RequestMethod.GET)
  public List<SellOrderDto> getListHistorySell(@RequestParam(required = true) String seller) {
    List<SellOrderDto> result = sellMedicineService.getHistorySell(seller);
    return result;
  }

  @RequestMapping(value = "/getSellOrder", method = RequestMethod.GET)
  public SellOrderDto getSellOrderDtoById(@RequestParam(required = true) Integer sellOrderId) {
    return sellMedicineService.getHistorySell(sellOrderId);
  }

  @RequestMapping(value = "/my-history-betweendays", method = RequestMethod.GET)
  public List<SellOrderDto> getListHistorySellBetweenDays(
      @RequestParam(required = true) String fromDate,
      @RequestParam(required = true) String toDate) {
    UserDetailCustom user = (UserDetailCustom) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
    if (StringUtils.isEmpty(user.getUsername())) {
      return null;
    }
    List<SellOrderDto> result = sellMedicineService
        .getHistorySell(user.getUsername(), fromDate, toDate);
    return result;

  }
  @RequestMapping(value = "/gen-money",method = RequestMethod.GET)
  public List<String> genMoney(@RequestParam Double  money){
    List<String> r = new ArrayList<>();
    r.add(CommonUtils.genSoTienBangChu(money));
    return r;
  }

}
