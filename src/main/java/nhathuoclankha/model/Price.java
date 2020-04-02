package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "price")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//	@OneToOne(mappedBy = "price",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Medicine medicine;

  private Integer medicineId;

  private Instant dateApply;

  public Integer getMedicineId() {
    return medicineId;
  }


  public void setMedicineId(Integer medicineId) {
    this.medicineId = medicineId;
  }

  public Instant getDateApply() {
    return dateApply;
  }


  public void setDateApply(Instant dateApply) {
    this.dateApply = dateApply;
  }

  private Long boughtPrice;

  private Long sellForCompanyPrice;

  private Long sellForFarmPrice;

  private Long sellForPersonalPrice;


  public Integer getId() {
    return id;
  }


  public Long getBoughtPrice() {
    return boughtPrice;
  }


  public void setBoughtPrice(Long boughtPrice) {
    this.boughtPrice = boughtPrice;
  }


  public Long getSellForCompanyPrice() {
    return sellForCompanyPrice;
  }


  public void setSellForCompanyPrice(Long sellForCompanyPrice) {
    this.sellForCompanyPrice = sellForCompanyPrice;
  }


  public Long getSellForFarmPrice() {
    return sellForFarmPrice;
  }


  public void setSellForFarmPrice(Long sellForFarmPrice) {
    this.sellForFarmPrice = sellForFarmPrice;
  }


  public Long getSellForPersonalPrice() {
    return sellForPersonalPrice;
  }


  public void setSellForPersonalPrice(Long sellForPersonalPrice) {
    this.sellForPersonalPrice = sellForPersonalPrice;
  }


  public void setId(Integer idPrice) {
    this.id = idPrice;
  }

//


}
