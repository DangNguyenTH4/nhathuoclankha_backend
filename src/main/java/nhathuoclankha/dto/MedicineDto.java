package nhathuoclankha.dto;

public class MedicineDto {
	private String code;
	private int amount;
	private String name;
	private String unit;
	private Long priceForCompany;
	private Long priceForFarm;
	private Long priceForPersonal;
	private Long addMore;
	private Long total;

	public Long getAddMore() {
		return addMore;
	}

	public void setAddMore(Long addMore) {
		this.addMore = addMore;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Long getPriceForCompany() {
		return priceForCompany;
	}

	public void setPriceForCompany(Long priceForCompany) {
		this.priceForCompany = priceForCompany;
	}

	public Long getPriceForFarm() {
		return priceForFarm;
	}

	public void setPriceForFarm(Long priceForFarm) {
		this.priceForFarm = priceForFarm;
	}

	public Long getPriceForPersonal() {
		return priceForPersonal;
	}

	public void setPriceForPersonal(Long priceForPersonal) {
		this.priceForPersonal = priceForPersonal;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		MedicineDto other = (MedicineDto) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
