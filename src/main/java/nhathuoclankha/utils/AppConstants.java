package nhathuoclankha.utils;

public class AppConstants {

  public static class MedicineMessageConstants {
    private MedicineMessageConstants(){}
    public static String NOT_FOUND_MEDICINE_CODE = "Không tìm thấy mã thuốc: ";
    public static String EXISTED_MEDICINE_CODE = "Mã thuốc đã tồn tại!";
    public static String NOT_ENOUGH_QUANTITY = "Không tìm thấy mã thuốc: ";
    public static String MUST_NOT_BLANK_MEDICINE_XXX = "Mã thuốc và tên thuốc không được trống";
    public static String EMPTY_LIST_MEDICINE = "Chưa có thuốc nào được nhập";
  }
  public static class PriceMessageConstant{
    private PriceMessageConstant(){}
    public static String WRONG_PRICE = "Giá nhập không chính xác.";
  }
  public static class QuantityMessageConstant{
    private QuantityMessageConstant(){}
    public static String WRONG_AMOUNT = "Số lượng thêm không đúng";
  }
  public static class CompanyMessageConstant{
    private CompanyMessageConstant(){}
    public static String NOT_EXIST_COMPANY = "Công ty không tồn tại!";
  }
}
