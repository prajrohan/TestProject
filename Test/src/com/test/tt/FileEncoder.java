package com.test.tt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;

public class FileEncoder {

	public static void main(String[] args) {
		
		
		File f1 = new File("E:/Annoucement/mysoreGPS.txt");
		File f2 = new File("E:/Annoucement/abc1.txt");
		
		String base64=" ";
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
//			br = new BufferedReader(new FileReader(f1));
//			String line;
//			while((line = br.readLine())!=null) {
//			base64 = Base64.encodeBase64String(line.getBytes());
//			}
//			System.out.println(base64);
			byte [] buffer = new byte[(int)f1.length() + 100];
			int length = new FileInputStream(f1).read(buffer);
			base64 = Base64.encodeBase64String(buffer);
			FileOutputStream fos=new FileOutputStream(f2);
			byte b [] = base64.getBytes();
			fos.write(b);
			fos.close();
			System.out.println(base64);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	
}
