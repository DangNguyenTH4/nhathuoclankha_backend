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

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "price")
@Getter
@Setter
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//	@OneToOne(mappedBy = "price",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private Medicine medicine;

  private Integer medicineId;

  private Instant dateApply;

  private Double boughtPrice;
  private Double sellForCompanyPrice;
  private Double sellForFarmPrice;
  private Double sellForPersonalPrice;

  private Integer importDiscount;
  private Double boughtPriceAfterDiscount;

}
