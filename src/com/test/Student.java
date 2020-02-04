package com.test;

import com.csv.CsvColumn;

public class Student{

	@CsvColumn(name="Student-Number")
	private int id;
	
	@CsvColumn
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
