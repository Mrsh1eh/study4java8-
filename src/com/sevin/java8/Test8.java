package com.sevin.java8;

import java.util.function.Function;

public class Test8 {
	
	public static void main(String[] args) {
		//System.out.println("Sequential sum done in: " + measureSumPerf(ParalleStreams::sequentialSum, 10_000_000) + " msecs");
		//System.out.println("Iterative sum done in: " + measureSumPerf(ParalleStreams::iterativeSum, 10_000_000) + " msecs");
		//System.out.println("parallel sum done in: " + measureSumPerf(ParalleStreams::paralleSum, 10_000_000) + " msecs");
		System.out.println("SideEffect parallel sum done in: " + measureSumPerf(ParalleStreams::sideEffectParallelSum, 10_000_000) + " msecs");
	
		System.out.println("==============================================================");
	
		System.out.println("SideEffect parallel sum done in: " + measureSumPerf(ParalleStreams::paralleSum, 10_000_000) + " msecs");
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n){
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest) fastest = duration;
		}
		return fastest;
	}
}
