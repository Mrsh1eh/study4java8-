package com.sevin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;


public class DocumentDemo {
	
	public static void main(String[] args) {
		A b = new B();
		C d = new D();
		System.out.println(Arrays.toString(b.getClass().getAnnotations()));
		System.out.println(Arrays.toString(d.getClass().getAnnotations()));
		System.out.println(b.getClass().getAnnotation(DocumentA.class));
	}
}

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentA{
	
}


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentB{

}

@DocumentA
class A{}

@DocumentB
class B extends A{}

@DocumentB
class C{}

class D extends C{}


