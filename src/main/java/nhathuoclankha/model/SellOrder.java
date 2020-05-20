package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sellorder")
@Getter
@Setter
public class SellOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  // @OneToMany(mappedBy = "sellOrder")
  // private Set<SellOrderDetail> sellOrderDetail;
  @ManyToOne
  private Customer customer;
  private Instant time;
  private Double total;
  private String seller;
  /**
   * Lứa gà
   */
  private String numberOfSell;
  /**
   * Ngày  vào gà
   */
  private String timeInputAnimal;
  private String note;


}
