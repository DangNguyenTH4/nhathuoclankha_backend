package nhathuoclankha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
	private int id;
	private String name;
	private String phoneNumber;
	private String type;
	private String traiDungThuoc;

	private String typeOfCustomer;
}
