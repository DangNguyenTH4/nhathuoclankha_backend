package nhathuoclankha.dto;

public class ReportDto {
	private String customerName;
	private String medicineName;
	private String medicineCode;
	private String dateSell;
	private String unit;
	private int amount;
	private Long price;
	private Long total;
	private int exsitingQuantity;
	private int boughtQuanity;
	
	

	public int getExsitingQuantity() {
		return exsitingQuantity;
	}

	public void setExsitingQuantity(int exsitingQuantity) {
		this.exsitingQuantity = exsitingQuantity;
	}

	public int getBoughtQuanity() {
		return boughtQuanity;
	}

	public void setBoughtQuanity(int boughtQuanity) {
		this.boughtQuanity = boughtQuanity;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getMedicineCode() {
		return medicineCode;
	}

	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}


	public String getDateSell() {
		return dateSell;
	}

	public void setDateSell(String dateSell) {
		this.dateSell = dateSell;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}
