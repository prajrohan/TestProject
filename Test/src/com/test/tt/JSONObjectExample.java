package com.test.tt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectExample {

	
	public static void main(String[] args) {
		JSONObject nObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		jArray.put("ABC");
		jArray.put("XYZ");
		
		JSONArray jArray1 = new JSONArray();
		
		jArray1.put("abc");
		jArray1.put("xyz");
		
		JSONObject obj = new JSONObject();
		
		try {
			obj.put("small", jArray1);
			obj.put("caps", jArray);
			nObj.put("obj", obj);
			nObj.put("obj1", obj);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(nObj);
	}
}
