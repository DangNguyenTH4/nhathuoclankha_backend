package nhathuoclankha.composite;

import java.io.Serializable;

import javax.persistence.Column;

public class ImportOrderDetaiKey implements Serializable {
	private static final long serialVersionUID = 123L;
	@Column(name="medicine_id")
	private Integer medicineId;
	@Column(name="import_order_id")
	private Integer importOrderId;
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public Integer getImportOrderId() {
		return importOrderId;
	}
	public void setImportOrderId(Integer sellOrderId) {
		this.importOrderId = sellOrderId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((importOrderId == null) ? 0 : importOrderId.hashCode());
		result = prime * result + ((medicineId == null) ? 0 : medicineId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportOrderDetaiKey other = (ImportOrderDetaiKey) obj;
		if (importOrderId == null) {
			if (other.importOrderId != null)
				return false;
		} else if (!importOrderId.equals(other.importOrderId))
			return false;
		if (medicineId == null) {
			if (other.medicineId != null)
				return false;
		} else if (!medicineId.equals(other.medicineId))
			return false;
		return true;
	}
	
	
}
