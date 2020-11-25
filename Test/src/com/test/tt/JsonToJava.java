package com.test.tt;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToJava {

	public static void main(String[] args) {
		
		String myJson = "[{\"English\":{\"display\":\"English Display\",\"description\":\"English Description\"}},\r\n" + 
				"{\"Kannada\":{\"display\":\"Kannada Display\",\"description\":\"Kannada Description\"}}]";
	
	
		try {
			
			JSONArray lang = new JSONArray(myJson);
			//System.out.println("lang Length"+lang.length());
			for(int i=0; i<lang.length(); i++) {
				JSONObject jsonObj = lang.getJSONObject(i);
				String k = (String)jsonObj.keys().next();
				//System.out.println(lang.get(i));
				System.out.println("Key-->"+k);
				//System.out.println(jsonObj.getJSONObject(k));
				
				JSONObject jsonDisp = jsonObj.getJSONObject(k);
				Iterator <String> listKEY = jsonDisp.keys();
					do {
						String newKEY = listKEY.next().toString();
		                System.out.println(newKEY);
		                System.out.println("Value-->"+jsonDisp.getString(newKEY));
					   }while (listKEY.hasNext());
			
		}

	
	
	}catch (Exception e) {

		System.out.println("Error");
	}

	
	
}
}
