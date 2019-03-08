package com.sevin.java8;

import java.util.function.Function;

public class Lambda {

	Function<Object, String> f = o -> String.valueOf(o);
}
