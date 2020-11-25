package com.test.tt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArray {

	public static void main(String[] args) throws JSONException {
		
	
		String json =" {\r\n" + 
				"        \"252017\":[\r\n" + 
				"                    {\r\n" + 
				"                    \"name\":\"abc\",\r\n" + 
				"                    \"email\":\"abc@gmail.com\"\r\n" + 
				"                    },\r\n" + 
				"                    {\r\n" + 
				"                    \"name\":\"xyz\",\r\n" + 
				"                    \"email\":\"xyz@gmail.com\"\r\n" + 
				"                    }\r\n" + 
				"                ],\r\n" + 
				"        \"252018\":[\r\n" + 
				"                    {\r\n" + 
				"                    \"name\":\"Prajwal\",\r\n" + 
				"                    \"email\":\"rohan@gmail.com\"\r\n" + 
				"                    },\r\n" + 
				"                    {\r\n" + 
				"                    \"name\":\"rohan\",\r\n" + 
				"                    \"email\":\"prajwal.@gmail.com\"\r\n" + 
				"                    }\r\n" + 
				"                 ]\r\n" + 
				"    }";
		
		
		JSONObject jObj = new JSONObject(json);
		
		Iterator <String> listKEY = jObj.keys();
		
		do {
			String newKEY = listKEY.next().toString();
            System.out.println("Bus Server Id-->"+newKEY);
            JSONArray jArray = new JSONArray(jObj.get(newKEY).toString());
            for(int i=0;i<jArray.length();i++) {
            	JSONObject jo = new JSONObject(jArray.get(i).toString());
            	System.out.println("Name-->"+jo.getString("name"));
            	System.out.println("Email-->"+jo.getString("email"));
            }
            
		}while (listKEY.hasNext());
		
	

	
	}
		

	
	
}
