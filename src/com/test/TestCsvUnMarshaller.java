package com.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import com.csv.CsvContext;
import com.csv.CsvUnmarshaller;

public class TestCsvUnMarshaller {

	public static void main(String[] args) {
		try {
			
			CsvContext<Student> context = new CsvContext<>();
					
			InputStream is = new FileInputStream("D://Development//InterviewQuestion//WorkSpace//CSVMarShaller//student.csv");
			
			CsvUnmarshaller<Student> umMarshaller = new CsvUnmarshaller<Student>(context);
			
			List<?> objectList =  umMarshaller.unmarshall(new Student(),is);
			
			System.out.println(objectList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
