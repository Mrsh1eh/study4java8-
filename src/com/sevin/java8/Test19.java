package com.sevin.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Test19 {

	public static void main(String[] args) {
		LocalDate of = LocalDate.of(2018, 8, 7);
		System.out.println(of.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(of.format(DateTimeFormatter.ISO_LOCAL_DATE));
		
		System.out.println(LocalDateTime.of(2018, 8, 7, 17, 18, 30).format(DateTimeFormatter.BASIC_ISO_DATE));
		
		String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		System.out.println(format);
		System.out.println(LocalDateTime.now());
		
		System.out.println(IntStream.iterate(2, n -> n + 1));
		
		System.out.println(filter(9, n -> String.valueOf(n * 3)));
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		
		System.out.println(new Date(1533308318617L));
		
		long a = 3000000000002451896L;
		System.out.println(a%128);
		System.out.println(a);
	}
	
	public static String filter(Integer t, Function<Integer, String> f){
		return f.apply(t);
	}
	
	
}
