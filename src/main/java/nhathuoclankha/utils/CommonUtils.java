package nhathuoclankha.utils;

import io.swagger.models.auth.In;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class CommonUtils {

    public static void main(String[] args) {
//    String s = genSoTienBangChu(1059999.0);
      String s = genSoTienBangChu(1509090.0);
    System.out.println(s);

  }
  static Map<Integer, String> numberStringMap;

  static {
    numberStringMap = new HashMap<>();
    numberStringMap.put(0, "không");
    numberStringMap.put(1, "một");
    numberStringMap.put(2, "hai");
    numberStringMap.put(3, "ba");
    numberStringMap.put(4, "bốn");
    numberStringMap.put(5, "năm");
    numberStringMap.put(6, "sáu");
    numberStringMap.put(7, "bảy");
    numberStringMap.put(8, "tám");
    numberStringMap.put(9, "chín");
  }

  public static String genSoTienBangChu(Double total) {

    log.info(">>>Gen so tien bang chu");
    if (total == null) {
      return numberStringMap.get(0);
    }
    if (total < 0) {
      return "Không có số tiền âm!";
    }
    if (total > 999999999) {
      return "Số quá lớn!";
    }
    boolean isTrieuLe = false;
    String ty = null;
    String trieu = null;
    String nghin = null;
    StringBuilder sb = new StringBuilder();
    if (total > 0) {
      Double nghinNumber = total % 1000;
      nghin = buildBaSoLienTiep(nghinNumber);
      total = total / 1000;
      total = Math.floor(total);
      if (total > 0) {
        Double trieuNumber = total % 1000;
        if (trieuNumber == 0) {
          trieu = " lẻ ";
          isTrieuLe = true;
        } else {
          trieu = buildBaSoLienTiep(trieuNumber);
        }
        total = total / 1000;
        total = Math.floor(total);
      }
    }

    if (total > 0) {
      Double tyNumber = total % 1000;
      ty = buildBaSoLienTiep(tyNumber);
      total = total / 1000;
      total = Math.floor(total);
    }
    if (total > 0) {
      return "Số quá lớn!";
    }
    if (!StringUtils.isEmpty(ty)) {
      sb.append(ty).append(" tỷ ");
    }
    if (!StringUtils.isEmpty(trieu)) {
      if (isTrieuLe) {
        sb.append(trieu);
      } else {
        sb.append(trieu).append(" triệu ");
      }
    }
    if (!StringUtils.isEmpty(nghin)) {
      sb.append(nghin).append(" nghìn ");
    }
    sb.append("đồng.");

    String result = sb.toString();
    log.info(">> so tien : {}", result);
    Character first = Character.toUpperCase(result.charAt(0));
    return first + result.substring(1, result.length());
  }

  private static String buildBaSoLienTiep(Double baSo) {
    if (baSo == null || baSo == 0) {
      return null;
    }
    Integer dvNumber = null;
    Integer chucNumber = null;
    Integer tramNumber = null;
    if(baSo>0){
      dvNumber = (int)(baSo%10);
      baSo = Math.floor(baSo/10);
    }
    if(baSo>0){
      chucNumber = (int)(baSo%10);
      baSo = Math.floor(baSo/10);
    }
    if(baSo>0){
      tramNumber = (int)(baSo%10);
      baSo = Math.floor(baSo/10);
    }


    StringBuilder sb = new StringBuilder();
    if(tramNumber!=null){
      switch (tramNumber){
        case 0:
          break;
        default:
          sb.append(numberStringMap.get(tramNumber)).append(" trăm ");
      }
    }
    if(chucNumber!=null){
      if(tramNumber!=null){
        switch (chucNumber){
          case 0:
            sb.append(" lẻ ");
            break;
          case 1:
            sb.append(" mười ");
            break;
          default:
            sb.append(numberStringMap.get(chucNumber)).append(" mươi ");
            break;
        }
      }else{
        switch (chucNumber){
          case 0:
            break;
          case 1:
            sb.append( " mười ");
            break;
          default:
            sb.append(numberStringMap.get(chucNumber)).append(" mươi ");
            break;
        }
      }
    }
    if(dvNumber!=null){
      if(chucNumber!=null && chucNumber == 1){
        switch (dvNumber){
          case 0 :
            break;
          default:
            sb.append(numberStringMap.get(dvNumber));
            break;
        }
      }else if(chucNumber!=null && chucNumber!=1 && chucNumber !=0){
        switch (dvNumber){
          case 0:
            break;
          case 1:
            sb.append(" mốt ");
            break;
          default:
            sb.append(numberStringMap.get(dvNumber));
            break;
        }
      }
      else{
        sb.append(numberStringMap.get(dvNumber)) ;
      }
    }
    return sb.toString();
  }
  public static boolean isCollectionEmpty(List<?> collection){
    return collection == null || collection.size() ==0;
  }

}
