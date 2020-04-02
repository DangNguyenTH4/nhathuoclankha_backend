package nhathuoclankha.mapper;

import nhathuoclankha.dto.MedicineDtoAdmin;
import nhathuoclankha.model.Medicine;
import org.springframework.stereotype.Component;

@Component
public class MedicineAdminMapper  extends Mapper<Medicine, MedicineDtoAdmin>  {

  @Override
  public Medicine toEntity(MedicineDtoAdmin d) {
    Medicine entity = new Medicine();
    entity.setCode(d.getCode());
//    entity.setCompany(d.getCompany().);
    entity.setId(d.getId());
    entity.setMedicineName(d.getMedicineName());
//    entity.setPrice(d.getPrice());
    entity.setQuantityExsiting(d.getQuantityExsiting());
    entity.setUnit(d.getUnit());
    entity.setDateCreate(d.getDateCreate());
    return entity;
  }

  @Override
  public MedicineDtoAdmin toDto(Medicine entity) {
    MedicineDtoAdmin dto = new MedicineDtoAdmin();
    dto.setCode(entity.getCode());
    //Remove list medicine from result
    entity.getCompany().setListMedicine(null);
    dto.setCompanyName(entity.getCompany().getCompanyName());
    dto.setId(entity.getId());
    dto.setMedicineName(entity.getMedicineName());
    dto.setPriceBought(entity.getPrice().getBoughtPrice());
    dto.setPriceSell(entity.getPrice().getSellForPersonalPrice());
    dto.setQuantityExsiting(entity.getQuantityExsiting());
    dto.setUnit(entity.getUnit());
    dto.setDateCreate(entity.getDateCreate());
    return dto;
  }
}
