package com.sevin.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamFork<T> {

	private final Stream<T> stream;
	
	private final Map<Object, Function<Stream<T>, ?>> forks = new HashMap<>();

	public StreamFork(Stream<T> stream) {
		super();
		this.stream = stream;
	}
	
	public StreamFork<T> fork(Object key, Function<Stream<T>, ?> f){
		forks.put(key, f);
		
		forks.entrySet();
		return this;
	}
	
	
	public void test(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名类方式");
			}
		}).start();
		
		new Thread(() -> System.out.println("Lambda方式")).start();
	}
}
