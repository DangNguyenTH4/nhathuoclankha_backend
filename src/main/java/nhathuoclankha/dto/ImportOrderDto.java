package nhathuoclankha.dto;

import java.time.Instant;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportOrderDto {
	private Integer id;
	private Instant importDate;
	private String staffName;
	private String maHoaDonReal;
	private List<MedicineDto> listMedicineImport;
}
