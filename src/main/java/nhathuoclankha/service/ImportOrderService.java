package nhathuoclankha.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nhathuoclankha.auth.service.SecurityService;
import nhathuoclankha.composite.ImportOrderDetaiKey;
import nhathuoclankha.dto.ImportOrderDto;
import nhathuoclankha.dto.MedicineDto;
import nhathuoclankha.exceptions.EmptyException;
import nhathuoclankha.mapper.ImportOrderMapper;
import nhathuoclankha.mapper.MedicineMapper;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.model.ImportOrderDetail;
import nhathuoclankha.model.Medicine;
import nhathuoclankha.repository.ImportOrderDetailRepository;
import nhathuoclankha.repository.ImportOrderRepository;
import nhathuoclankha.repository.ImportOrderRepositoryCustomer;
import nhathuoclankha.utils.DateUtils;

@Service
@Slf4j
public class ImportOrderService {
  @Autowired
  private ImportOrderRepository importOrderRepository;
  @Autowired
  private ImportOrderRepositoryCustomer importOrderRepositoryCustomer;
  @Autowired
  private MedicineService medicineService;
  @Autowired
  private ImportOrderMapper importOrderMapper;
  @Autowired
  private MedicineMapper medicineMapper;

  @Autowired
  private SecurityService securityService;
  
  @Autowired
  private ImportOrderDetailRepository importOrderDetailRepository;

  @Transactional
  public ImportOrderDto importOrder(ImportOrderDto importOrderDto) {
	log.info(">>> Import order processing ...");
    List<MedicineDto> listMedicineDto = importOrderDto.getListMedicineImport();
    if(listMedicineDto==null || listMedicineDto.size()==0) {
      throw new EmptyException("Chưa có thuốc nào được nhập.");
    }
    ImportOrder importOrder = importOrderMapper.toEntity(importOrderDto);
    //Get user name:
    String username = securityService.getUserName();
    log.info(">>> client user : {}, serveruser: {}",importOrder.getStaffName(),username);
    log.info(">>> user : {}, import new order.",username);
    
    importOrder.setStaffName(username);
    
    if (importOrder.getImportDate() == null)
      importOrder.setImportDate(Instant.now());
    List<ImportOrderDetail> listImportOrderDetail = new ArrayList<ImportOrderDetail>();
    importOrder = importOrderRepository.save(importOrder);

    for (MedicineDto medicineDto : listMedicineDto) {
      // Update quantity total
      Medicine m = medicineService.updateQuantityExistingWhenImport(medicineDto);
      // Create import order detail
      ImportOrderDetail importOrderDetail = new ImportOrderDetail();
      importOrderDetail.setAmount(medicineDto.getAmount());
      if (importOrderDto.getImportDate() == null)
        importOrderDetail.setDateImport(Instant.now());
      importOrderDetail.setMedicine(m);
      importOrderDetail.setImportOrder(importOrder);
      log.info("---------" + importOrderDetail.getImportOrderDetailKey().getImportOrderId()
              + "---------" + importOrderDetail.getImportOrderDetailKey().getMedicineId());
      importOrderDetail.getImportOrderDetailKey().setMedicineId(m.getId());
      importOrderDetail.getImportOrderDetailKey().setImportOrderId(importOrder.getId());
      log.info("---------" + importOrderDetail.getImportOrderDetailKey().getImportOrderId()
              + "---------" + importOrderDetail.getImportOrderDetailKey().getMedicineId());
      System.out.println(importOrder.getId());
      importOrderDetail.setPriceId(m.getPrice().getId());

      listImportOrderDetail.add(importOrderDetail);

    }
    importOrderRepository.save(importOrder);
    listImportOrderDetail = importOrderDetailRepository.saveAll(listImportOrderDetail);
    importOrderDto = importOrderMapper.toDto(importOrder);
    // importOrderDto.setListMedicineImport(importOrderMapper.toListDto(listImportOrderDetail));
    return importOrderDto;
  }


  public List<ImportOrderDto> getHistoryImportOrder(String fromDate, String toDate) {
    Instant from = DateUtils.getInstantDateQuery(fromDate);
    Instant to = DateUtils.getInstantDateQuery(toDate);
    List<ImportOrderDto> resultList = new ArrayList<>();
    // get List import order
    List<ImportOrder> listImportOrder =
        importOrderRepositoryCustomer.findImportOrderBetween(from, to);
    for (ImportOrder io : listImportOrder) {
      ImportOrderDto dto = new ImportOrderDto();
      dto = importOrderMapper.toDto(io);
      List<MedicineDto> listMedicineDto = new ArrayList<>();
      // find import order detail by import order id
//      List<ImportOrderDetail> importOrderDetailList =
//          importOrderDetailRepository.findByImportOrder(io);
      List<ImportOrderDetail> importOrderDetailList =
          importOrderDetailRepository.findByImportOrderByOrderByMedicineCode(io.getId());
     

      for (ImportOrderDetail iod : importOrderDetailList) {
        MedicineDto medicineDto = medicineMapper.toDto(iod.getMedicine());
        medicineDto.setAmount(iod.getAmount());
        medicineDto.setAddMore(0L);
        listMedicineDto.add(medicineDto);
      }
      dto.setListMedicineImport(listMedicineDto);
      // Add import order dto to list and response
      resultList.add(dto);
    }

    return resultList;
  }
}
