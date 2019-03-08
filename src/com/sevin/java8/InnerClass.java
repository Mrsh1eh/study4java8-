package com.sevin.java8;

import java.util.function.Function;

public class InnerClass {
	Function<Object, String> f = new Function<Object, String>(){
		public String apply(Object o){
			return String.valueOf(o);
		}
	};
}
