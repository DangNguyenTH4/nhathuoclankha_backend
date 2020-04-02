package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import nhathuoclankha.composite.ImportOrderDetaiKey;

@Entity
@Table(name = "importOrderDetail")
public class ImportOrderDetail {
	@EmbeddedId
	private ImportOrderDetaiKey importOrderDetailKey;
	
	private Instant dateImport;
	private int amount;
	@ManyToOne
	@MapsId("import_order_id")
	@JoinColumn(name = "import_order_id")
	private ImportOrder importOrder;
	@ManyToOne
	@MapsId("medicine_id")
	@JoinColumn(name = "medicine_id")
	private Medicine medicine;
	private Integer priceId; 
	
	public ImportOrderDetail() {
		importOrderDetailKey = new ImportOrderDetaiKey();
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}
	public ImportOrderDetaiKey getImportOrderDetailKey() {
		return importOrderDetailKey;
	}
	public void setImportOrderDetailKey(ImportOrderDetaiKey importOrderDetailKey) {
		this.importOrderDetailKey = importOrderDetailKey;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public Instant getDateImport() {
		return dateImport;
	}
	public void setDateImport(Instant dateImport) {
		this.dateImport = dateImport;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ImportOrder getImportOrder() {
		return importOrder;
	}
	public void setImportOrder(ImportOrder importOrder) {
		this.importOrder = importOrder;
	}
	
	
}
