package com.sevin.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class Test17 {
	public static void main(String[] args) {
		LocalDate of = LocalDate.of(2018, 8, 7);
		System.out.println(of);
		
		LocalDate withDayOfMonth = of.withDayOfMonth(9);
		System.out.println(withDayOfMonth);
		
		LocalDate with = of.with(ChronoField.DAY_OF_YEAR, 59);
		System.out.println(with);
		
		int i = of.get(ChronoField.DAY_OF_MONTH);
		System.out.println(i);
		
		LocalDate plusWeeks = of.plusWeeks(1);
		System.out.println(plusWeeks);
		
		LocalTime of2 = LocalTime.of(15, 19, 40);
		OffsetTime atOffset = of2.atOffset(ZoneOffset.MIN);
		System.out.println(atOffset);
	}
}
