package nhathuoclankha.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "customer")
	private Set<SellOrder> sellOrder;
	private String phoneNumber;
	private String name;
	private String type; // Farm,Company,Personal
	private String traiDungThuoc;
	
	
	public Set<SellOrder> getSellOrder() {
		return sellOrder;
	}
	public void setSellOrder(Set<SellOrder> sellOrder) {
		this.sellOrder = sellOrder;
	}
	public String getTraiDungThuoc() {
		return traiDungThuoc;
	}
	public void setTraiDungThuoc(String traiDungThuoc) {
		this.traiDungThuoc = traiDungThuoc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}
