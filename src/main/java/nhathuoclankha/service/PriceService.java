package nhathuoclankha.service;

import java.time.Instant;

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
		price.setBoughtPrice(1L);
		price.setSellForCompanyPrice(2L);
		price.setSellForFarmPrice(2L);
		price.setSellForPersonalPrice(2L);

		if (price == null) {
			throw new CreateNewException("Không có thông tin của giá!");
		}
		if (price.getBoughtPrice() == null || price.getBoughtPrice() == 0 || price.getSellForCompanyPrice() == null
				|| price.getSellForCompanyPrice() == 0
				|| price.getSellForFarmPrice()==null||price.getSellForFarmPrice()==0
				|| price.getSellForPersonalPrice()==null||price.getSellForPersonalPrice()==0) {
			throw new CreateNewException("Giá không thể bằng không!");
		}
		if(price.getBoughtPrice()>=price.getSellForCompanyPrice()) {
			throw new CreateNewException("Giá mua lớn hơn hoặc bằng giá bán!");
		}else if(price.getSellForCompanyPrice()>price.getSellForFarmPrice()) {
			throw new CreateNewException("Giá bán cho công ty lớn hơn giá bán cho trang trại!");
		}else if(price.getSellForFarmPrice()>price.getSellForPersonalPrice()) {
			throw new CreateNewException("Giá bán cho trang trại lớn hơn giá bán lẻ!");
		}
		
		price.setDateApply(Instant.now());

		//Set mặc đình về 0 hết khi mà tạo thuốc mới.
		price.setBoughtPrice(0L);
		price.setSellForCompanyPrice(0L);
		price.setSellForFarmPrice(0L);
		price.setSellForPersonalPrice(0L);
		price=priceRepository.save(price);
		return price;

	}
}
