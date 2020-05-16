package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;
import nhathuoclankha.composite.SellOrderDetailKey;

@Entity
@Getter
@Setter
public class SellOrderDetail {
	@EmbeddedId
	private SellOrderDetailKey sellOrderDetailKey;
	
	@ManyToOne
	@MapsId("sell_order_id")
	@JoinColumn(name ="sell_order_id")
	private SellOrder sellorder;
	private int amount;
	private Integer priceId;
	//Only Đơn giá, chưa cộng thêm addMore
	private Long priceSell;
	private Long realSellPrice;

	private Instant time;
	@ManyToOne
	@MapsId("medicine_id")
	@JoinColumn(name="medicine_id")
	private Medicine medicine;
	
	
	

	public SellOrderDetail(){
		this.sellOrderDetailKey = new SellOrderDetailKey();
	}

	public void setMedicine(Medicine medicine) {
		this.sellOrderDetailKey.setMedicineId(medicine.getId());
		this.medicine = medicine;
	}
	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrderDetailKey.setSellOrderId(sellOrder.getId());
		this.sellorder = sellOrder;
	}

}
