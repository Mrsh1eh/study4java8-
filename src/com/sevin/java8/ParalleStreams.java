package com.sevin.java8;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParalleStreams {

	public static long sequentialSum(long n){
		return Stream.iterate(1L, i -> i +1).limit(n).reduce(0L, Long::sum);
	}
	
	public static long iterativeSum(Long n){
		long result = 0;
		for (int i = 0; i <= n; i++) {
			result = result + i;
		}
		return result;
	}
	
	public static long paralleSum(long n) {
		//return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
		return LongStream.rangeClosed(1, n).parallel().sum();
		 
	}
	
	public static long sideEffectParallelSum(long n){
		Accumulator a = new Accumulator();
		LongStream.rangeClosed(1, n).parallel().forEach(a::add);
		return a.total;
		//return LongStream.rangeClosed(1, n).parallel().sum();
	}
	
	public static class Accumulator{
		public  long total = 0;
		public void add(long value) { 
			total = total + value;
		}
	}
}
