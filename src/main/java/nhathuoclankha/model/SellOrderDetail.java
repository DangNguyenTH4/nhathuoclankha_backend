package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import nhathuoclankha.composite.SellOrderDetailKey;

@Entity
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
	private Long addMore;
	private Instant time;
	@ManyToOne
	@MapsId("medicine_id")
	@JoinColumn(name="medicine_id")
	private Medicine medicine;
	
	
	
	public Instant getTime() {
		return time;
	}


	public void setTime(Instant time) {
		this.time = time;
	}


	public Long getAddMore() {
		return addMore;
	}


	public void setAddMore(Long addMore) {
		this.addMore = addMore==null?0:addMore;
	}
	
	
	public SellOrderDetail() {
		sellOrderDetailKey = new SellOrderDetailKey();
	}
	
	
	public SellOrderDetailKey getSellOrderDetailKey() {
		return sellOrderDetailKey;
	}


	public void setSellOrderDetailKey(SellOrderDetailKey sellOrderDetailKey) {
		this.sellOrderDetailKey = sellOrderDetailKey;
	}


	public SellOrder getSellorder() {
		return sellorder;
	}


	public void setSellorder(SellOrder sellorder) {
		this.sellorder = sellorder;
	}


	public Long getPriceSell() {
		return priceSell;
	}


	public void setPriceSell(Long priceSell) {
		this.priceSell = priceSell;
	}


	public SellOrderDetailKey getId() {
		return sellOrderDetailKey;
	}
	public void setId(SellOrderDetailKey id) {
		this.sellOrderDetailKey = id;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.sellOrderDetailKey.setMedicineId(medicine.getId());
		this.medicine = medicine;
	}
	public SellOrder getSellOrder() {
		return sellorder;
	}
	public void setSellOrder(SellOrder sellOrder) {
		this.sellOrderDetailKey.setSellOrderId(sellOrder.getId());
		this.sellorder = sellOrder;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Integer getPriceId() {
		return priceId;
	}
	public void setPriceId(Integer price) {
		this.priceId = price;
	}
	
	
	
}
