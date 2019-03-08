package com.sevin.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static java.time.temporal.TemporalAdjusters.*;

public class Test18 {

	public static void main(String[] args) {
		LocalDate of = LocalDate.of(2018, 8, 13);		
		System.out.println(of.with(nextOrSame(DayOfWeek.TUESDAY)));
		
		System.out.println(of.with(lastDayOfMonth()));
		LocalDate with = of.with(dayOfWeekInMonth(1, DayOfWeek.TUESDAY));
		System.out.println(with);
		
		System.out.println(of.with(firstInMonth(DayOfWeek.TUESDAY)));
		
		System.out.println(of.with(lastDayOfYear()));
		
		System.out.println(of.with(next(DayOfWeek.TUESDAY)));
		
		System.out.println(of.get(ChronoField.DAY_OF_WEEK));
		
		//获取下一个工作日
		LocalDate with2 = of.with((temporal) -> {
			Temporal t1 = temporal.with(nextOrSame(DayOfWeek.FRIDAY));
			if(temporal.get(ChronoField.DAY_OF_WEEK) < t1.get(ChronoField.DAY_OF_WEEK)){
				return temporal.plus(1, ChronoUnit.DAYS);
			}else{
				return temporal.with(next(DayOfWeek.MONDAY));
			}
		});
		System.out.println(with2);
	}
}
