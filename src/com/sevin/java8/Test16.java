package com.sevin.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Test16 {

	public static void main(String[] args) {
		
		//Duration 用于计算两个时间的间隔，秒与纳秒之间
		Duration between = Duration.between(LocalTime.of(14, 13, 50), LocalTime.of(14, 13, 59));
		System.out.println(between.toString());
		
		System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.now()));
		
		Duration ofMillis = Duration.ofMinutes(10);
		System.out.println(ofMillis);
		
		Duration of = Duration.of(30, ChronoUnit.HOURS);
		System.out.println(of);
		
		//Period 用于计算两个时间的间隔，日期
		Period between2 = Period.between(LocalDate.of(2018, 8, 7), LocalDate.of(2018, 8, 5));
		System.out.println(between2);
		
		Period ofMonths = Period.ofMonths(2);
		System.out.println(ofMonths);
		
		Period of2 = Period.of(2, 6, 1);
		System.out.println(of2);
		
		Duration parse = Duration.parse("");
		System.out.println(parse);
	}
}
