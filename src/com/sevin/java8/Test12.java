package com.sevin.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.atomic.AtomicBoolean;

public class Test12 {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		
		LocalDate date = LocalDate.of(2018, 8, 6);
		System.out.println(date.getYear());
		System.out.println(date.getDayOfYear());
		Month month = date.getMonth();
		System.out.println(month);
		int dayOfMonth = date.getDayOfMonth();
		System.out.println(dayOfMonth);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println(dayOfWeek);
		int lengthOfMonth = date.lengthOfMonth();
		System.out.println(lengthOfMonth);
		
		boolean leapYear = date.isLeapYear();
		System.out.println(leapYear);
		
		int lengthOfYear = date.lengthOfYear();
		System.out.println(lengthOfYear);

	}
}
