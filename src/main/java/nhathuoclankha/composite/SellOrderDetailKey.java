package nhathuoclankha.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SellOrderDetailKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 123L;
	@Column(name="medicine_id")
	private int medicineId;
	@Column(name="sell_order_id")
	private int sellOrderId;
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getSellOrderId() {
		return sellOrderId;
	}
	public void setSellOrderId(int sellOrderId) {
		this.sellOrderId = sellOrderId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medicineId;
		result = prime * result + sellOrderId;
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
		SellOrderDetailKey other = (SellOrderDetailKey) obj;
		if (medicineId != other.medicineId)
			return false;
		if (sellOrderId != other.sellOrderId)
			return false;
		return true;
	}


}
