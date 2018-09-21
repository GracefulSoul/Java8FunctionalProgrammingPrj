package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TemporalAdjustersTest {
	
	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		System.out.println("두번 째 금요일 " + d.with(dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));
		d.with(firstDayOfNextMonth());
		System.out.println("첫번 째 목요일 " + d.with(dayOfWeekInMonth(1, DayOfWeek.THURSDAY)));
		System.out.println("이번 달의 마지막 날 " + d.with(lastDayOfMonth()));
		System.out.println("다음 수요일 " + d.with(next(DayOfWeek.WEDNESDAY)));
		System.out.println("이전 화요일 " + d.with(previous(DayOfWeek.TUESDAY)));
		
	}
	
}
