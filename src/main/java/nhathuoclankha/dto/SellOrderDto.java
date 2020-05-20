package nhathuoclankha.dto;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellOrderDto {
  private int id;
  private CustomerDto customer;
  private Instant time;
  private Double total;
  private Set<MedicineDto> listMedicines;
  private String seller;

  // When see history -> return invoice dto for client
  private List<InvoiceDto> listInvoice;

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
