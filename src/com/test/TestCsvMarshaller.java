package com.test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csv.CsvContext;
import com.csv.CsvMarshaller;

public class TestCsvMarshaller {

	public static void main(String[] args) {

		try {
			
			CsvContext<Student> context = new CsvContext<>();
			
			OutputStream os = new FileOutputStream("D://Development//InterviewQuestion//WorkSpace//CSVMarShaller//student.csv");
			
			CsvMarshaller<Student> marshaller = new CsvMarshaller<>(context);
			
			List<Student> students = new ArrayList<Student>();
			Student student = new Student();
			student.setId(123);
			student.setName("John");
			students.add(student);
			
			Student student1 = new Student();
			student1.setId(124);
			student1.setName("David");
			students.add(student1);
			
			Student student2 = new Student();
			student2.setId(125);
			student2.setName("Smith");
			students.add(student2);
			
			Iterator<Student> it1 = students.iterator();
			
			marshaller.marshall(it1, os);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
