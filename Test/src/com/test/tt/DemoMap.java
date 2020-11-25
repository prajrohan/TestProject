package com.test.tt;

import java.util.HashMap;

public class DemoMap {

	
	public static void main(String[] args) {
		
		
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		
		map.put(0, "General Annoucement");
		map.put(1, "Safety Audio");
		map.put(2, "Last Stop");
		map.put(3, "Do's and Don'ts");
		map.put(4, "Music ");
		map.put(5, "Break Fast");
		map.put(6, "Will be Stopping for Break fast in 15mins");
		map.put(7, "Will be Stopping for Break fast in 30mins");
		map.put(8, "This stop is for break fast please return back to bus in 15mins");
		map.put(9, "This stop is for break fast please return back to bus in 30mins");
		map.put(10, "Lunch");
		map.put(11, "Will be Stopping for Lunch in 15mins");
		map.put(12, "Will be Stopping for Lunch in 15mins");
		map.put(13, "Will be Stopping for Lunch in 30mins");
		map.put(14, "This stop is for Lunch please return back to bus in 15mins");
		map.put(15, "This stop is for Lunch please return back to bus in 30mins");
		map.put(16, "Dinner");
		map.put(17, "Will be Stopping for Dinner in 15mins");
		map.put(18, "Will be Stopping for Dinner in 30mins");
		map.put(19, "This stop is for Dinner please return back to bus in 15mins");
		map.put(20, "This stop is for Dinner please return back to bus in 30mins");
		map.put(21, "Break");
		map.put(22, "Will be Stopping for Break in 15mins");
		map.put(23, "Will be Stopping for Break in 30mins");
		map.put(24, "This stop is for Dinner please return back to bus in 15mins");
		map.put(25, "This stop is for Dinner please return back to bus in 30mins");
		map.put(26, "Will be Stopping for Break in 15mins");
		map.put(27, "Restroom/Toilet");
		map.put(28, "Will be Stopping for restroom in 15mins");
		map.put(29, "This stop is for Break please restroom back to bus in 15mins");
		map.put(30, "This stop is for Break please restroom back to bus in 30mins");
		
		
		HashMap<Integer, String> map1 = new HashMap<Integer,String>();
		
		map1.put(0, "On Route Announcement");
		map1.put(1, "Electronic city");
		map1.put(2, "Silk Board");
		map1.put(3, "Madiwala");
		map1.put(4, "Kalasipalya");
		map1.put(5, "Majestic");
		map1.put(6, "Hosur");
		map1.put(7, "Electronic city");
		map1.put(8, "Silk Board");
		map1.put(9, "Madiwala");
		map1.put(10, "Kalasipalya");
		map1.put(11, "Majestic");
		map1.put(12, "Goa Drop Points");
		map1.put(13, "Electronic city");
		map1.put(14, "Silk Board");
		map1.put(15, "Madiwala");
		map1.put(16, "Kalasipalya");
		map1.put(17, "Majestic");
		map1.put(18, "Electronic city");
		map1.put(19, "Silk Board");
		map1.put(20, "Madiwala");
		map1.put(21, "Kalasipalya");
		map1.put(22, "Majestic");
		map1.put(23, "Chennai Drop Points");
		map1.put(24, "Electronic city");
		map1.put(25, "Silk Board");
		map1.put(26, "Madiwala");
		map1.put(27, "Kalasipalya");
		map1.put(28, "Majestic");
		map1.put(29, "Electronic city");
		map1.put(30, "Silk Board");
		map1.put(31, "Madiwala");
		map1.put(32, "Kalasipalya");
		map1.put(33, "Majestic");
		
		int size;
		if(map1.size() > map.size()) {
			
			size = map1.size();
		}else {
			
			size = map.size();
		}
		
		for(int i=0;i<size;i++) {
			
			String gen = map.get(i);
			String places = map1.get(i);

			if(gen == null) {
				
				gen = " "; 
			}
			else if(places == null){
				
				places = " ";
			}
			
			System.out.println(gen+" - "+places);			
		}

	}
	
}
