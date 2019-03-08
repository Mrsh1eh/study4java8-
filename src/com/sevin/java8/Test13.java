package com.sevin.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test13 {

	public static void main(String[] args) {
		LocalTime of = LocalTime.of(16, 40, 25);
		System.out.println(of.toString());
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		int hour = of.getHour();
		System.out.println(hour);
		int minute = of.getMinute();
		System.out.println(minute);
		int second = of.getSecond();
		System.out.println(second);
		System.out.println(of.isAfter(now));
		
		LocalTime parse = LocalTime.parse("16:46:08");
		System.out.println(parse);

		//LocalDate.parse("2018-08-06", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
	}
}
