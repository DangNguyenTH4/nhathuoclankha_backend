package nhathuoclankha.dto;

public class CustomerDto {
	private int id;
	private String name;
	private String phoneNumber;
	private String type;
	private String traiDungThuoc;
	
	
	public String getTraiDungThuoc() {
		return traiDungThuoc;
	}
	public void setTraiDungThuoc(String traiDungThuoc) {
		this.traiDungThuoc = traiDungThuoc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
