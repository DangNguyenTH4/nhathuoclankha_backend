package nhathuoclankha.mapper;

import org.springframework.stereotype.Component;

import nhathuoclankha.dto.ImportOrderDetailDto;
import nhathuoclankha.model.ImportOrderDetail;

@Component
public class ImportOrderDetailMapper extends Mapper<ImportOrderDetail,ImportOrderDetailDto>{

	@Override
	public ImportOrderDetail toEntity(ImportOrderDetailDto d) {
		if(d!=null) {
			ImportOrderDetail e = new ImportOrderDetail();
			e.setAmount(d.getAmount());
			e.setDateImport(d.getDateImport());
			e.setImportOrderDetailKey(d.getImportOrderDetailKey());
			return e;
		}
		return null;
		
	}

	@Override
	public ImportOrderDetailDto toDto(ImportOrderDetail e) {
		if(e!=null) {
			ImportOrderDetailDto d = new ImportOrderDetailDto();
			d.setAmount(e.getAmount());
			d.setDateImport(e.getDateImport());
			d.setImportOrderDetailKey(e.getImportOrderDetailKey());
			return d;
		}
		return null;
	}

}
