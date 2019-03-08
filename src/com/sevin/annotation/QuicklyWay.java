package com.sevin.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class QuicklyWay{

	@IntegerValue(22)
	private int age;
		
	@IntegerValue(value = 1000, name = "�緹Ǯ")
	private int money;
	
	public static void main(String[] args) {
		Class<?> q = QuicklyWay.class;
		Field[] fields = q.getDeclaredFields();
		for (Field f : fields) {
			IntegerValue a = f.getDeclaredAnnotation(IntegerValue.class);
			System.out.println(a.value() + " " + a.name());
		}
	}
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue{
	
	int value() default 0;
	
	String name() default "";
}
