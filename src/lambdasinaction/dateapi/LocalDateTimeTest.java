package lambdasinaction.dateapi;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		// LocalDate 사용
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		LocalDate todayAgain = LocalDate.now();
		System.out.println(today.compareTo(todayAgain));
		
		System.out.println("년월일 " + today.getYear() + "/"
								   + today.getMonth() + " " + today.getMonthValue()+ "/"
								   + today.getDayOfMonth());
		
		System.out.println("요일 " + today.getDayOfWeek() + " "
				                 + today.getDayOfWeek().getValue());
		
		//특정 날짜를 지정해서 LocalDate 생성
		LocalDate endDay = LocalDate.of(2018, 12, 31);
		System.out.println("현재기준 몇 일 남아있는가? " + today.until(endDay, ChronoUnit.DAYS));
		System.out.println("현재기준 2개월 후 " + today.plusMonths(2));
		System.out.println(DayOfWeek.FRIDAY.plus(3));
		
		//LoacalDateTime 사용
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		LocalDate d = dt.toLocalDate();
		LocalTime t = dt.toLocalTime();
		System.out.println(d + " " + t);
		
		LocalDateTime dt2 = LocalDateTime.of(2018, 10, 1, 7, 10, 5);
		System.out.println(dt2);
		
		//Formatting
		dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		System.out.println(dt);
		
		//format을 직접 설정
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a", Locale.KOREAN);
		System.out.println(dt.format(myFormat));
	}

}
