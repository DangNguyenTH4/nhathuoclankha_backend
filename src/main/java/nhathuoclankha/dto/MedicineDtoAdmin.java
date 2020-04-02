package nhathuoclankha.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import nhathuoclankha.model.Company;
import nhathuoclankha.model.Price;
@Getter
@Setter
public class MedicineDtoAdmin {
	private Integer id;
	private String code;
	private String companyName;
	private String medicineName;
	private Long priceSell;
	private Long priceBought;
	private int quantityExsiting;
	private String unit;
	private Instant dateCreate;

	private Company company;
	private Price price;


	
}
