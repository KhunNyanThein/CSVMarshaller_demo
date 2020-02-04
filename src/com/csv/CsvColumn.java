package com.csv;

public @interface CsvColumn {
	public String name() default "";
}
