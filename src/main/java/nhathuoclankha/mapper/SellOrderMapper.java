package nhathuoclankha.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nhathuoclankha.dto.SellOrderDto;
import nhathuoclankha.model.SellOrder;

@Component
public class SellOrderMapper extends Mapper<SellOrder, SellOrderDto> {
	@Autowired
	CustomerMapper customerMapper;

	@Override
	public SellOrder toEntity(SellOrderDto d) {
		SellOrder e = null;
		if (d != null) {
			e = new SellOrder();
			e.setCustomer(customerMapper.toEntity(d.getCustomer()));
			e.setId(d.getId());
			e.setTime(d.getTime());
			e.setTotal(d.getTotal());
			e.setSeller(d.getSeller());
		}
		return e;
	}

	@Override
	public SellOrderDto toDto(SellOrder e) {
		SellOrderDto d = null;
		if (e != null) {
			d = new SellOrderDto();
			d.setCustomer(customerMapper.toDto(e.getCustomer()));
			d.setId(e.getId());
			d.setTime(e.getTime());
			d.setTotal(e.getTotal());
			d.setSeller(e.getSeller());
		}
		return d;
	}

}
