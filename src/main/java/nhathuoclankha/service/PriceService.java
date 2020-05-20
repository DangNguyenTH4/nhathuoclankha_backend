package nhathuoclankha.service;

import java.time.Instant;

import nhathuoclankha.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nhathuoclankha.exceptions.CreateNewException;
import nhathuoclankha.model.Price;
import nhathuoclankha.repository.PriceRepository;

@Service
public class PriceService {

  @Autowired
  PriceRepository priceRepository;

  public Price update(Price price) {
    return priceRepository.save(price);
  }

  public Price createPrice(Price price) {

    //Đổi requirement, không muốn nhập giá lúc tạo thuốc mới nữa
    //Nên set temp như này, tí nữa qua đoạn validate sẽ xóa đi về 0 hết
    price.setBoughtPrice(1.0);
    price.setSellForCompanyPrice(2.0);
    price.setSellForFarmPrice(2.0);
    price.setSellForPersonalPrice(2.0);

    if (price == null) {
      throw new CreateNewException("Không có thông tin của giá!");
    }
    if (price.getBoughtPrice() == null || price.getBoughtPrice() == 0
        || price.getSellForCompanyPrice() == null
        || price.getSellForCompanyPrice() == 0
        || price.getSellForFarmPrice() == null || price.getSellForFarmPrice() == 0
        || price.getSellForPersonalPrice() == null || price.getSellForPersonalPrice() == 0) {
      throw new CreateNewException("Giá không thể bằng không!");
    }
    if (price.getBoughtPrice() >= price.getSellForCompanyPrice()) {
      throw new CreateNewException("Giá mua lớn hơn hoặc bằng giá bán!");
    } else if (price.getSellForCompanyPrice() > price.getSellForFarmPrice()) {
      throw new CreateNewException("Giá bán cho công ty lớn hơn giá bán cho trang trại!");
    } else if (price.getSellForFarmPrice() > price.getSellForPersonalPrice()) {
      throw new CreateNewException("Giá bán cho trang trại lớn hơn giá bán lẻ!");
    }

    price.setDateApply(Instant.now());

    //Set mặc đình về 0 hết khi mà tạo thuốc mới.
    price.setBoughtPrice(0.0);
    price.setSellForCompanyPrice(0.0);
    price.setSellForFarmPrice(0.0);
    price.setSellForPersonalPrice(0.0);
    price = priceRepository.save(price);
    return price;
  }

  /**
   * Tạo bản ghi mới. Nếu có giá trị nào khác với giá trị cũ thì ghi lấy giá trị mới. Nếu không có
   * giá trị, hoặc giá trị bằng 0 thì lấy giá trị cũ (m.getPrice()).
   *
   * @param price
   * @param oldPrice
   * @return
   */
  public Price createAndSavePriceBaseOnOldPrice(Price price, Price oldPrice) {
    if (price.getBoughtPrice() == null) {
      price.setBoughtPrice(oldPrice.getBoughtPrice());
    }
    if (price.getSellForPersonalPrice() == null) {
      price.setSellForPersonalPrice(oldPrice.getSellForPersonalPrice());
    }
    if (price.getSellForCompanyPrice() == null) {
      price.setSellForCompanyPrice(oldPrice.getSellForCompanyPrice());
    }
    if (price.getSellForFarmPrice() == null) {
      price.setSellForFarmPrice(oldPrice.getSellForFarmPrice());
    }
    if (price.getDateApply() == null) {
      price.setDateApply(Instant.now());
    }
    price.setId(null);
    priceRepository.save(price);
    return price;
  }
}
