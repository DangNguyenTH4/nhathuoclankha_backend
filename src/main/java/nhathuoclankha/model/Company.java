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
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String companyName;
	@OneToMany(mappedBy =  "company")
	private Set<Medicine> listMedicine;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Set<Medicine> getListMedicine() {
		return listMedicine;
	}
	public void setListMedicine(Set<Medicine> listMedicine) {
		this.listMedicine = listMedicine;
	}
	
	
}
