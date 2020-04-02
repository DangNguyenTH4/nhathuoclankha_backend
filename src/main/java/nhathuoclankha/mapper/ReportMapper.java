package nhathuoclankha.mapper;

import org.springframework.stereotype.Component;

import nhathuoclankha.dto.ReportDto;
import nhathuoclankha.model.Report;
@Component
public class ReportMapper extends Mapper<Report,ReportDto> {

	@Override
	public Report toEntity(ReportDto d) {
		if(d==null) {
			return null;
		}
		Report e = new Report();
		e.setAmount(d.getAmount());
		e.setCustomerName(d.getCustomerName());
		e.setDateSell(d.getDateSell());
		e.setMedicineCode(d.getMedicineCode());
		e.setMedicineName(d.getMedicineName());
		e.setPrice(d.getPrice());
		e.setUnit(d.getUnit());
		e.setBoughtQuanity(d.getBoughtQuanity());
		e.setExsitingQuantity(d.getExsitingQuantity());
		
		return e;
	}

	@Override
	public ReportDto toDto(Report e) {
		if(e==null) {
			return null;
		}
		ReportDto d = new ReportDto();
		d.setAmount(e.getAmount());
		d.setCustomerName(e.getCustomerName());
		d.setDateSell(e.getDateSell());
		d.setMedicineCode(e.getMedicineCode());
		d.setMedicineName(e.getMedicineName());
		d.setPrice(e.getPrice());
		d.setUnit(e.getUnit());
		d.setPrice(e.getPrice());
		d.setBoughtQuanity(e.getBoughtQuanity());
		d.setExsitingQuantity(e.getExsitingQuantity());
		return d;
	}

}
