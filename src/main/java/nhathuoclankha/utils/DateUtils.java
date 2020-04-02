package nhathuoclankha.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.web.client.HttpClientErrorException.BadRequest;

import nhathuoclankha.exceptions.BadRequestException;

public class DateUtils {
	
  /**
   * 
   * @param year
   * @param month
   * @param day
   * @param isStartDate
   * @return
   */
	public static String getDateQuery(Integer year, Integer month, Integer day, Boolean isStartDate) {
		LocalDate today = LocalDate.now();
		if (year == null || year == 0 || year < 2019) {
			year = today.getYear();
		}
		if (month == null || month == 0 || month < 1 || month > 12) {
			month = 1;
		}
		if (day == null || day == 0 || day < 1 || day > 31) {
			day = 1;
		}
		LocalDate buildDate = LocalDate.of(year, month, day);
		if (isStartDate)
			return buildDate.atTime(0, 0, 0).toString();
		return buildDate.atTime(23, 59, 59, 999999999).toString();
	}
	/***
	 * 
	 * @param date : String pattern is : MM/dd/yyyy
	 * @param isStartDate
	 * @return
	 */
	public static String getDateQuery(String date,boolean isStartDate) {
		DateTimeFormatter dtf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate today =LocalDate.parse(date, dtf);
		if(isStartDate)
			return today.atTime(00, 00, 00).toString();
		return today.atTime(23, 59, 59, 999999999).toString();
	}
	/**
	 * getInstantDateQuery. Make sure : date was be parse to start date and end date before.
	 * @param date instantDate
	 * @return
	 */
	public static Instant getInstantDateQuery(String date) {
		try {
		Instant is = Instant.parse(date);
		return is;
		
		}catch (Exception e) {
			throw new BadRequestException("Ngày tháng không hợp lệ.");
		}
	}
	public static Instant getTodayInstant(boolean isStartDate) {
	  LocalDateTime ld = LocalDateTime.now();
	  if(isStartDate) {
	    ld = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), 0,0,0,0);
	  }else {
	    ld=LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), 23,59,59,999);
	  }
	  return ld.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();
	}
}
