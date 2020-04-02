package nhathuoclankha.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {

  @Override
  public String toString() {
    return "Medicine [id=" + id + ", company=" + company + ", medicineName=" + medicineName
        + ", price=" + price
        + ", quantityExsiting=" + quantityExsiting + ", unit=" + unit + ", code=" + code + "]";
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  private Company company;
  @Column(length = 100, unique = true)
  private String medicineName;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "price_id")
  private Price price;
//	@OneToMany(mappedBy = "medicine")
//	private List<SellOrderDetail> sellOrderDetail;

  private int quantityExsiting;

  private String unit;
  @Column(length = 100, unique = true)
  private String code;

  private Instant dateCreate;

  public Instant getDateCreate() {
    return this.dateCreate;
  }

  public void setDateCreate(Instant dateCreate) {
    this.dateCreate = dateCreate;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer idMedicine) {
    this.id = idMedicine;
  }

  public int getQuantityExsiting() {
    return quantityExsiting;
  }

  public void setQuantityExsiting(int quantityExsiting) {
    this.quantityExsiting = quantityExsiting;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public String getMedicineName() {
    return medicineName;
  }

  public void setMedicineName(String medicineName) {
    this.medicineName = medicineName;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }


}
