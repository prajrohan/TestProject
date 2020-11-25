package com.test.tt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datenow {

	public static void main(String[] args) {
		
		Date d = new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		System.out.println(sdf.format(d));
	}
	
}
