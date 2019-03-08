package com.sevin.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

public class Test14 {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
		System.out.println(now);
		
		LocalDateTime of = LocalDateTime.of(2018, Month.AUGUST, 6, 17, 03, 55);
		System.out.println(of.toString());
		
		LocalTime time = LocalTime.of(17, 03, 55);
		LocalDateTime atDate = time.atDate(LocalDate.of(2018, 8, 6));
		System.out.println(atDate);
		
		System.out.println(now.toLocalDate());
		System.out.println(now.toLocalTime());
		
	}
}
