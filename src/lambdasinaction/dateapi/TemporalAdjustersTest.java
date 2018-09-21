package lambdasinaction.dateapi;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.*;

import java.time.DayOfWeek;

public class TemporalAdjustersTest {
	
	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		System.out.println("�ι� ° �ݿ��� " + d.with(dayOfWeekInMonth(3, DayOfWeek.FRIDAY)));
		d.with(firstDayOfNextMonth());
		System.out.println("ù�� ° ����� " + d.with(dayOfWeekInMonth(1, DayOfWeek.THURSDAY)));
		System.out.println("�̹� ���� ������ �� " + d.with(lastDayOfMonth()));
		System.out.println("���� ������ " + d.with(next(DayOfWeek.WEDNESDAY)));
		System.out.println("���� ȭ���� " + d.with(previous(DayOfWeek.TUESDAY)));
		
	}
	
}
