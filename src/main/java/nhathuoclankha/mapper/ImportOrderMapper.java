package nhathuoclankha.mapper;

import org.springframework.stereotype.Component;

import nhathuoclankha.dto.ImportOrderDto;
import nhathuoclankha.model.ImportOrder;
@Component
public class ImportOrderMapper extends Mapper<ImportOrder, ImportOrderDto> {

	@Override
	public ImportOrder toEntity(ImportOrderDto d) {
		ImportOrder entity = null;
		if (d != null) {
			entity = new ImportOrder();
			entity.setId(d.getId());
			entity.setImportDate(d.getImportDate());
			entity.setStaffName(d.getStaffName());
		}
		return entity;
	}

	@Override
	public ImportOrderDto toDto(ImportOrder e) {
		ImportOrderDto dto = null;
		if(e!=null) {
			dto = new ImportOrderDto();
			dto.setId(e.getId());
			dto.setImportDate(e.getImportDate());
			dto.setStaffName(e.getStaffName());
		}
		return dto;
	}

}
