package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TheDayMartOffUsingLambda {
	
	public static void main(String[] args) {
//		LocalDate today = LocalDate.now();
		LocalDate today = LocalDate.of(2018, 9, 30);
		LocalDate theDayMartOff = today.with(temporal -> {
			//1. 기준이 되는 날짜를 구한다.
			LocalDate theDay = LocalDate.from(temporal);
			System.out.println("기준이 되는 날짜 " + theDay);
			//2. 둘째, 네째 일요일은 구한다.
			LocalDate secondDay = theDay.with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			LocalDate fourthDay = theDay.with(dayOfWeekInMonth(4, DayOfWeek.SUNDAY));
			//3. 기준날짜와 비교
			if(theDay.isBefore(secondDay)) {
				return secondDay;
			} else if (theDay.isBefore(fourthDay)) {
				return fourthDay;
			} else {
				return theDay.plusMonths(1)
							 .with(dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
			}
		});
		System.out.println("다음 Mart 쉬는 날은? " + theDayMartOff);
	}
	
}
