package com.csv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.csv.reader.CsvReader;
import com.csv.reader.SimpleCsvReader;

public class CsvUnmarshaller<T> {

    private final CsvContext<T> context;

    public CsvContext<T> getContext() {
        return context;
    }

    public CsvUnmarshaller(CsvContext<T> context) {
        this.context = context;
    }

    public List<T> unmarshall(T object ,InputStream inputStream) throws Exception {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
       
        CsvReader reader = new SimpleCsvReader(bufferedReader, context.getSeparator(), context.getQuote(), context.getComment());
       
        List<T> objectList = new ArrayList<>();
        
        try {
        	
        	String[] csvData = null;
        	
        	
        	reader.readLine();
        	
        	while((csvData = reader.readLine()) != null){
        		T obj = toObjectData(csvData, object);
        		objectList.add(obj);
        	}        	
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        return objectList;
    }
    
    @SuppressWarnings("unchecked")
	private T toObjectData(String[] csvRow, T object){
    	
    	 HashMap<String, String> hmap = new HashMap<String, String>();
    	 
    	try{
	    	Class<?> c = object.getClass();

	    	Field[] fields = c.getDeclaredFields();
	    	 
	    	 int index = 0;
	    	 for (Field field : fields) {
	    		 hmap.put(field.getName(), csvRow[index]);
	    		 index +=1;
	    	 }
	    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return (T) hmap;
    }
}
