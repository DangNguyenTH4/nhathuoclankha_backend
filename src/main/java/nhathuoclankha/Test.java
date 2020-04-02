package nhathuoclankha;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import nhathuoclankha.utils.DateUtils;

public class Test {
	public static void main(String[] args) {
		LocalDateTime ld = LocalDateTime.now();
		System.out.println(ld.toString());
		ld = LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), 0,0,0,0);
		Instant it = ld.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();
		ld=LocalDateTime.of(ld.getYear(), ld.getMonth(), ld.getDayOfMonth(), 23,59,59,999);
		Instant it2 = ld.atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toInstant();
		System.out.println(it.toString());
		System.out.println(it2.toString());
	}


	
}
