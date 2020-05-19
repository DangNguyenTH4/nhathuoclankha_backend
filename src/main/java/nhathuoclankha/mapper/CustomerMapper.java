package nhathuoclankha.mapper;

import org.springframework.stereotype.Component;

import nhathuoclankha.dto.CustomerDto;
import nhathuoclankha.model.Customer;

@Component
public class CustomerMapper extends Mapper<Customer, CustomerDto> {

	@Override
	public CustomerDto toDto(Customer e) {
		CustomerDto dto = new CustomerDto();
		if (e != null) {
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setPhoneNumber(e.getPhoneNumber());
			dto.setType(e.getType());
			dto.setTraiDungThuoc(e.getTraiDungThuoc());
			dto.setTypeOfCustomer(e.getTypeOfCustomer());
		}
		return dto;
	}

	@Override
	public Customer toEntity(CustomerDto d) {
		Customer e = new Customer();
		if (d != null) {
			e.setId(d.getId());
			e.setName(d.getName());
			e.setPhoneNumber(d.getPhoneNumber());
			e.setType(d.getType());
			e.setTraiDungThuoc(d.getTraiDungThuoc());
			e.setTypeOfCustomer(e.getTypeOfCustomer());
		}
		return e;
	}

}
