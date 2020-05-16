package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import nhathuoclankha.composite.ImportOrderDetaiKey;

@Entity
@Table(name = "importOrderDetail")
@Getter
@Setter
public class ImportOrderDetail {
	@EmbeddedId
	private ImportOrderDetaiKey importOrderDetailKey;
	
	private Instant dateImport;
	private int amount;
//	private Integer priceId;
	private String expiryDate;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "price_id")
	private Price price;
	@ManyToOne
	@MapsId("import_order_id")
	@JoinColumn(name = "import_order_id")
	private ImportOrder importOrder;
	@ManyToOne
	@MapsId("medicine_id")
	@JoinColumn(name = "medicine_id")
	private Medicine medicine;

	
	public ImportOrderDetail() {
		importOrderDetailKey = new ImportOrderDetaiKey();
	}
}
