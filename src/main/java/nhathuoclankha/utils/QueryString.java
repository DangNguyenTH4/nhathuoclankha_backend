package nhathuoclankha.utils;

public class QueryString {

  public static final String REPORT_QUERY =  "select m.code,m.quantity_exsiting as soluongton,sum(sod.amount) as SoluongBan from nhathuoc.sell_order_detail sod "
      + "inner join nhathuoc.sellorder so on so.id=sod.sell_order_id "
      + "inner join nhathuoc.medicine m on m.id=sod.medicine_id "
      + "where so.time is not null and so.time between ?1 and ?2 group by m.code,m.quantity_exsiting;";
  public static final String GET_IMPORT_BETWEEN_DATE = "select * from nhathuoc.importorder where import_date between ?1 and ?2 order by id asc";
  public static final String FINDBY_IMPORTORDER_ORDER_BY_MEDICINE = "select iod.* from nhathuoc.import_order_detail iod ,  nhathuoc.medicine m "
      + "where import_order_id = ?1 "
      + "and m.id = iod.medicine_id "
      + "order by m.code asc";
  public static final String SELECE_INVOICE_DTO = "select m.code as \"productName\" , sod.price_sell as \"unitPrice\" , sod.amount as amount , m.unit as unit ,sod.add_more  from nhathuoc.sell_order_detail sod , nhathuoc.medicine m " + 
      " where sod.medicine_id = m.id and sod.sell_order_id = ?1";
}
