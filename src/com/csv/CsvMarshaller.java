package com.csv;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csv.writer.CsvWriter;
import com.csv.writer.SimpleCsvWriter;

public class CsvMarshaller<T> {

    private final CsvContext<T> context;

    public CsvMarshaller(CsvContext<T> context) {
        this.context = context;
    }
    
    public void marshall(Iterator<T> iterator, OutputStream outputStream) throws Exception {
        
    	try {
    		
        	 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        	 
        	 CsvWriter printer = new SimpleCsvWriter(writer, context.getSeparator(), context.getLineSeparator());
        	
        	boolean writeHeader = true;
        	
        	System.out.println("=>start write to csv.");
        	
            while (iterator.hasNext()) {
                            	
            	T t = iterator.next();
            	
            	if(writeHeader){
            		
            		Class<?> c = t.getClass(); 
        	    	Field[] fields = c.getDeclaredFields();
        	    	List<String> csvHeader = new ArrayList<>(fields.length);
            		 for (Field field : fields) {
        	    		 field.setAccessible(true);
        	    		 String name = field.getName();
        	    		 csvHeader.add(new String(name));
        	    	 }
            		 
            		printer.write(csvHeader.toArray(new String[csvHeader.size()]));
                    printer.writeln();
            	}
            	
            	
            	String [] strings = toCsvData(t);
            	
            	printer.write(strings);
               printer.writeln();
                writeHeader = false;
            }            
            printer.flush();
            System.out.println("=>success write data to csv.");
            
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    
    private String[] toCsvData(T object){
    	
    	try{
	    	Class<?> c = object.getClass();

	    	Field[] fields = c.getDeclaredFields();
	    	
	    	List<String> list = new ArrayList<String>(fields.length);
	    	
	    	 for (Field field : fields) {
	    		 field.setAccessible(true);
	    		 Object value = field.get(object);
	    		 list.add(new String(value.toString()));
	    	 }
	    	 return list.toArray(new String[list.size()]);
    	}catch(Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }
}
