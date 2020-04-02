package nhathuoclankha.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sellorder")
public class SellOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  // @OneToMany(mappedBy = "sellOrder")
  // private Set<SellOrderDetail> sellOrderDetail;
  @ManyToOne
  private Customer customer;
  private Instant time;
  private Long total;
  private String seller;

  public String getSeller() {
    return seller;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Instant getTime() {
    return time;
  }

  public void setTime(Instant time) {
    this.time = time;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }



}
