package nhathuoclankha.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceDto {

  private String  productName;
  private Long unitPrice;
  private int amount;
  private String unit;
  private Long addMore;
}
