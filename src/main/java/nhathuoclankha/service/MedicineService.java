package nhathuoclankha.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import nhathuoclankha.auth.model.UserDetailCustom;
import nhathuoclankha.mapper.MedicineAdminMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.dto.MedicineDtoAdmin;
import nhathuoclankha.exceptions.CreateNewException;
import nhathuoclankha.exceptions.EntityNotFoundException;
import nhathuoclankha.exceptions.ExistingQuantityException;
import nhathuoclankha.exceptions.OverExistingQuantityEception;
import nhathuoclankha.mapper.MedicineMapper;
import nhathuoclankha.model.Company;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.model.Price;
import nhathuoclankha.repository.MedicineRepository;

@Service
public class MedicineService {

  @Autowired
  private MedicineRepository medicineRepository;
  @Autowired
  private MedicineMapper medicineMapper;
  @Autowired
  private PriceService priceService;
  @Autowired
  private CompanyService companyService;
  @Autowired
  private MedicineAdminMapper medicineAdminMapper;

  private Logger logger = LoggerFactory.getLogger(MedicineService.class);

  public Medicine updateQuantityExsitingWhenSell(MedicineDto dto) {
    List<Medicine> list = medicineRepository.findByCode(dto.getCode());
    Medicine medicine = null;
    if (list != null && list.size() != 0) {
      medicine = list.get(0);
    }
    Medicine result = null;
    if (medicine != null) {
      if (medicine.getQuantityExsiting() < dto.getAmount() || dto.getAmount() <= 0) {
        logger.info(dto.getAmount() + "");
        logger.error("Over or Amount invalid");
        throw new OverExistingQuantityEception("Số lượng tồn không đủ. Mã : " + medicine.getCode());
      } else {
        int existing = medicine.getQuantityExsiting() - dto.getAmount();
        medicine.setQuantityExsiting(existing);
        result = medicineRepository.save(medicine);
      }
      return result;
    } else {
      throw new EntityNotFoundException("Không tìm thấy mã thuốc: " + dto.getCode());
    }

  }

  public Medicine updateQuantityExistingWhenImport(MedicineDto dto) {
    List<Medicine> list = medicineRepository.findByCode(dto.getCode());
    Medicine medicine = null;
    if (list != null && list.size() != 0) {
      medicine = list.get(0);
    }
    Medicine result = null;
    if (medicine != null) {
      if (dto.getAmount() <= 0) {
        logger.info(dto.getAmount() + "");
        logger.error("Amount is invalid");
        throw new ExistingQuantityException("Số lượng thêm không đúng");
      } else {
        int existing = medicine.getQuantityExsiting() + dto.getAmount();
        medicine.setQuantityExsiting(existing);
        result = medicineRepository.save(medicine);
      }
      return result;
    } else {
      throw new EntityNotFoundException("Không tìm thấy mã thuốc: " + dto.getCode());
    }
  }

  @Transactional
  public List<MedicineDtoAdmin> createNew(List<MedicineDtoAdmin> listMedicineDto,
      boolean isNewCompany) {
    List<Medicine> listMedicine = medicineMapper.toListEntityFromDtoAdmin(listMedicineDto);
    List<Medicine> listMedicineResult = new ArrayList<Medicine>();
    for (Medicine m : listMedicine) {
      Medicine temp = createOne(m, isNewCompany);
      listMedicineResult.add(temp);
    }
    listMedicineDto = medicineMapper.toListDtoAdmin(listMedicineResult);
    return listMedicineDto;
  }

  @Transactional
  public MedicineDtoAdmin createNewOne(MedicineDtoAdmin dto, boolean isNewCompany) {
    Medicine entity = medicineMapper.toEntityFromDtoAdmin(dto);
    entity = createOne(entity, isNewCompany);
    dto = medicineMapper.toDtoAdmin(entity);
    return dto;
  }

  private Medicine createOne(Medicine medicine, boolean isNewCompany) {
    List<Medicine> list = medicineRepository.findByCode(medicine.getCode());
    Medicine temp = null;
    if (list != null && list.size() != 0) {
      temp = list.get(0);
    }

    if (temp != null) {
      throw new CreateNewException("Mã thuốc đã tồn tại!");
    }
    // get company from clientMedicineAdminMapper
    Company com = medicine.getCompany();
    if (isNewCompany) {
      if (com != null) {
        // check existed company
        Company tempCom = companyService.findByName(com.getCompanyName());
        if (tempCom == null) {
          // create new when is not exist
          com = companyService.createOne(com);
        } else {
          com = tempCom;
        }
      }

    } else {
      com = companyService.findById(com.getId());
    }
    if (com == null && !isNewCompany) {
      throw new EntityNotFoundException("Công ty không tồn tại!");
    }
    medicine.setCompany(com);
    Price price = medicine.getPrice();
    // create new price
    price = priceService.createPrice(price);
    // update price
    medicine.setPrice(price);
    medicine.setQuantityExsiting(0);
    medicine.setDateCreate(Instant.now());

    medicine = medicineRepository.save(medicine);
    price.setMedicineId(medicine.getId());
    // update medicine for Price ID
    priceService.update(price);
    return medicine;
  }

  /**
   * get list MedicineDto.
   *
   * @return
   */
  public List<MedicineDto> getGetAllOrderByMedicineName() {
    List<Medicine> list = medicineRepository.findAllByOrderByMedicineName();
    List<MedicineDto> listDto = medicineMapper.toListDto(list);
    return listDto;
  }

  public List<MedicineDtoAdmin> getAllMedicineAdminOrderByName() {

    List<Medicine> list = medicineRepository.findAllByOrderByMedicineName();

    List<MedicineDtoAdmin> listDto = medicineAdminMapper.toListDto(list);
    UserDetailCustom user = (UserDetailCustom) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
    //Only lankha user can see bought price
    if (!"lankha".equalsIgnoreCase(user.getUsername())) {
      listDto.stream().forEach(a -> {
        a.setPriceBought(-1L);
      });
    }
    return listDto;
  }
}
