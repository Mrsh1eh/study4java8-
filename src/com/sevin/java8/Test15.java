package com.sevin.java8;

import java.time.Instant;
import java.time.LocalDateTime;

public class Test15 {

	public static void main(String[] args) {
		Instant now = Instant.now();
		System.out.println(now .toString());
		
		LocalDateTime now2 = LocalDateTime.now();
		System.out.println(now2);
		
		Instant ofEpochSecond = Instant.ofEpochSecond(3);
		System.out.println(ofEpochSecond);
		
		Instant ofEpochSecond2 = Instant.ofEpochSecond(2, 1_000_000_00);
		System.out.println(ofEpochSecond2);
		
		Instant ofEpochSecond3 = Instant.ofEpochSecond(4, -1_000_0);
		System.out.println(ofEpochSecond3);
		
		Instant ofEpochSecond4 = Instant.ofEpochSecond(3, 0);
		System.out.println(ofEpochSecond4);
		
		System.out.println(1 << 3);
	}
}
