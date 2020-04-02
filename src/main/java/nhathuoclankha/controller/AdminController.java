package nhathuoclankha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nhathuoclankha.dto.ImportOrderDto;
import nhathuoclankha.dto.MedicineDtoAdmin;
import nhathuoclankha.dto.ReportDto;
import nhathuoclankha.dto.SellOrderDto;
import nhathuoclankha.exceptions.NotSupportAnyMoreException;
import nhathuoclankha.model.ImportOrder;
import nhathuoclankha.service.ImportOrderService;
import nhathuoclankha.service.MedicineService;
import nhathuoclankha.service.ReportService;
import nhathuoclankha.service.SellMedicineService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MedicineService medicineService;
	@Autowired
	private ReportService reportService;

	@Autowired
	private ImportOrderService importOrderService;

	@Autowired
	private SellMedicineService sellMedicineService;

	@PostMapping("/create")
	public ResponseEntity<List<MedicineDtoAdmin>> create(@RequestBody List<MedicineDtoAdmin> listMedicineDto,
			@RequestParam(required = false) boolean isNewCompany) {
		List<MedicineDtoAdmin> result = medicineService.createNew(listMedicineDto, isNewCompany);
		return ResponseEntity.ok(result);
	}

	@GetMapping("/report-monthly")
	public ResponseEntity<List<ReportDto>> reportMonthly(int month) {
		List<ReportDto> result = null;
		return ResponseEntity.ok(result);
	}

	@GetMapping("/report-daily")
	public void reportDaily() {

	}

	@GetMapping("/report-yearly")
	public void reportYearly() {

	}

	@GetMapping("/report")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ReportDto> report(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		return reportService.getReport(fromDate, toDate);
	}

	@GetMapping("/history-import-order")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ImportOrderDto> getHistoryImport(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		List<ImportOrderDto> listResult = importOrderService.getHistoryImportOrder(fromDate, toDate);

		return listResult;
	}

	@GetMapping("/history-sell-order")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<SellOrderDto> getHistorySell(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		List<SellOrderDto> listResult = sellMedicineService.getHistorySell(fromDate, toDate);

		return listResult;
	}

	@GetMapping("/report2")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<ReportDto> report2() {
		return reportService.getReport(null, null);
	}

	@PostMapping("/get-list-medicine")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<MedicineDtoAdmin>> getListAll() {
		List<MedicineDtoAdmin> listResult = medicineService.getAllMedicineAdminOrderByName();

		return new ResponseEntity<>(listResult, HttpStatus.OK);
	}

	@PostMapping("/detail-history-sell")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<SellOrderDto> detailSell(@RequestParam(required=false) String parameters,@RequestParam(required = false) String fromDate,
	      @RequestParam(required = false) String toDate) throws NotSupportAnyMoreException{
	  return sellMedicineService.getDetailHistorySell(parameters, fromDate, toDate);
  }
}
