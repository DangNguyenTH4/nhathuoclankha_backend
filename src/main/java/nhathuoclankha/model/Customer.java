package nhathuoclankha.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
@Getter
@Setter
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
	private String typeOfCustomer;
	
}
