package nhathuoclankha.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.dto.MedicineDtoAdmin;
import nhathuoclankha.model.Medicine;

@Component
public class MedicineMapper extends Mapper<Medicine, MedicineDto> {

	@Override
	public MedicineDto toDto(Medicine e) {
		MedicineDto dto = null;
		if (e != null) {
			dto = new MedicineDto();
			dto.setId(e.getId());
			dto.setCode(e.getCode());
			dto.setAmount(e.getQuantityExsiting());
			dto.setName(e.getMedicineName());
			dto.setUnit(e.getUnit());
			dto.setPriceForCompany(e.getPrice().getSellForCompanyPrice());
			dto.setPriceForFarm(e.getPrice().getSellForFarmPrice());
			dto.setPriceForPersonal(e.getPrice().getSellForPersonalPrice());
			dto.setTotal(0L);
		}
		return dto;
	}

	@Override
	public Medicine toEntity(MedicineDto d) {
		if(d!=null) {
			Medicine e = new Medicine();
			e.setCode(d.getCode());
			e.setId(d.getId());
//			e.setCompany(d.);
//			e.setId();
			e.setMedicineName(d.getName());
//			e.setPrice(d.getP);
			return e;
		}
		return null;
	}
	public Medicine toEntityFromDtoAdmin(MedicineDtoAdmin admin) {
		if(admin!=null) {
			Medicine e = new Medicine();
			e.setCode(admin.getCode());
			e.setCompany(admin.getCompany());
			e.setId(admin.getId());
			e.setMedicineName(admin.getMedicineName());
			e.setPrice(admin.getPrice());
			e.setQuantityExsiting(admin.getQuantityExsiting());
			e.setUnit(admin.getUnit());
			return e;
		}
		return null;
	}
	public MedicineDtoAdmin toDtoAdmin(Medicine e) {
		if(e!=null) {
			MedicineDtoAdmin ad = new MedicineDtoAdmin();
			ad.setCode(e.getCode());
//			ad.setCompany(e.getCompany());
			ad.setId(e.getId());
			ad.setMedicineName(e.getMedicineName());
//			ad.setPrice(e.getPrice());
			ad.setQuantityExsiting(e.getQuantityExsiting());
			ad.setUnit(e.getUnit());
			return ad;
		}
		return null;
	}
	public List<MedicineDtoAdmin> toListDtoAdmin(List<Medicine> e) {
		List<MedicineDtoAdmin> listDto = null;
		if(e!=null)
			listDto = e.parallelStream().map(this::toDtoAdmin).collect(Collectors.toList());
		return listDto;
	}

	public List<Medicine> toListEntityFromDtoAdmin(List<MedicineDtoAdmin> d) {
		List<Medicine> listDto = null;
		if(d!=null)
			listDto = d.parallelStream().map(this::toEntityFromDtoAdmin).collect(Collectors.toList());
		return listDto;
	}

}
