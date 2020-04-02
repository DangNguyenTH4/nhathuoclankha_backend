package nhathuoclankha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.dto.MedicineDtoAdmin;
import nhathuoclankha.mapper.MedicineMapper;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.repository.MedicineRepository;
import nhathuoclankha.service.MedicineService;

@RestController
@RequestMapping("/medicine")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@CrossOrigin
public class MedicineController {
  @Autowired
  private MedicineService medicineService;
  @Autowired
  private MedicineRepository medicineRepository;
  @Autowired
  private MedicineMapper medicineMapper;

  /***
   * GET: /medicine/get-all
   * 
   * @return
   */
  @GetMapping("/get-all")
  public List<MedicineDto> getListAllMedicine() {
    return medicineService.getGetAllOrderByMedicineName();

  }

  /**
   * Add a new medicine
   * @param dto
   * @return
   */
  @PostMapping("/newone")
  public MedicineDtoAdmin createNewOne(@RequestBody MedicineDtoAdmin dto) {
    MedicineDtoAdmin result = null;
    result = medicineService.createNewOne(dto, true);
    return result;
  }
}
