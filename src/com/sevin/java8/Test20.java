package com.sevin.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Test20 {

	public static void main(String[] args) {
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		System.out.println(zoneId.toString());
		
		System.out.println(zoneId.getRules());
		
		ZoneId of = ZoneId.of("Asia/Shanghai");
		
		LocalDate of2 = LocalDate.of(2018, Month.AUGUST, 18);
		System.out.println(of2.atStartOfDay(of));
		
		LocalDateTime of3 = LocalDateTime.of(2018, Month.AUGUST, 18, 17, 45, 4);
		System.out.println(of3.atZone(of));
		
		System.out.println(Instant.now().atZone(of));
		
		Instant instant = of3.toInstant(ZoneOffset.ofHours(0));
		System.out.println(instant);
		
		LocalDateTime ofInstant = LocalDateTime.ofInstant(instant, of);
		System.out.println(ofInstant);
	}
}
