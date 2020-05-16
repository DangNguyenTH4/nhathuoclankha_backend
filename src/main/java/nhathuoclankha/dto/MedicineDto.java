package nhathuoclankha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicineDto {

  private int id;
  private String code;
  private int amount;
  private String name;
  private String unit;

  private Long priceForCompany;
  private Long priceForFarm;
  private Long priceForPersonal;
	//Bought price for Import Order
	private Long boughtPrice;
	//dd/mm/yyyy
	private String expiryDate;

	private Long realSellPrice;
  private Long total;

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
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    MedicineDto other = (MedicineDto) obj;
    if (code == null) {
      if (other.code != null) {
        return false;
      }
    } else if (!code.equals(other.code)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }


}
