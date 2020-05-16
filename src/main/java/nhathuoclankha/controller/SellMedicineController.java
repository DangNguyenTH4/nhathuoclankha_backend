package nhathuoclankha.controller;

import java.time.Instant;
import java.util.List;
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

  @GetMapping("add-medicine")
  public Medicine addMedicine(@RequestParam(required = false) String code,
      @RequestParam(required = false) String name, @RequestParam(required = false) Long price)
      throws NotSupportAnyMoreException {
    Medicine medicine = new Medicine();
    medicine.setMedicineName(name);
    medicine.setQuantityExsiting(20);
    medicine.setUnit("goi");
    medicine.setCode(code);
    Price price1 = new Price();
    price1.setDateApply(Instant.now());
    price1.setBoughtPrice(price);
    price1.setSellForCompanyPrice(price + 1000L);
    price1.setSellForFarmPrice(price + 2000L);
    price1.setSellForPersonalPrice(price + 3000L);
    priceRepository.save(price1);
    medicine.setPrice(price1);
    medicineRepository.saveAndFlush(medicine);
    price1.setMedicineId(medicine.getId());
    priceRepository.save(price1);
    throw new NotSupportAnyMoreException("Không hỗ trợ nữa");

  }

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

}
