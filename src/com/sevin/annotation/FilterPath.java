package com.sevin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(FilterPaths.class)
@Inherited
public @interface FilterPath {
	String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface FilterPaths{
	FilterPath[] value();
}

@FilterPath("/web/list")
class CC{
	
}

/*@FilterPath("/web/update")
@FilterPath("/web/add")
@FilterPath("/web/del")*/
class AA extends CC{
	public static void main(String[] args) {
		Class<?> a = AA.class;
		FilterPath[] fp = a.getAnnotationsByType(FilterPath.class);
		for (FilterPath f : fp) {
			System.out.println(f.value());
		}
	}
}
