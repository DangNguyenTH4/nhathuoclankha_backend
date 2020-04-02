package nhathuoclankha.dto;

import java.time.Instant;
import java.util.List;

public class ImportOrderDto {
	private Integer id;
	private Instant importDate;
	private String staffName;
	private List<MedicineDto> listMedicineImport;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Instant getImportDate() {
		return importDate;
	}
	public void setImportDate(Instant importDate) {
		this.importDate = importDate;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public List<MedicineDto> getListMedicineImport() {
		return listMedicineImport;
	}
	public void setListMedicineImport(List<MedicineDto> listMedicineImport) {
		this.listMedicineImport = listMedicineImport;
	}
	
	
}
