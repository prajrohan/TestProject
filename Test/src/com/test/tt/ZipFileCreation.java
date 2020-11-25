package com.test.tt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileCreation {


	
	public static void main(String[] args) {
		
		List<String> filePath = new ArrayList<String>();
		filePath.add("E:/Annoucement/audio/Malleshwaram.mp3");
		filePath.add("E:/Annoucement/image/Malleshwaram.jpg");
		
		
		ZipOutputStream zos = null;
		try {
			
			FileOutputStream fos = new FileOutputStream("E:/Annoucement/sam.zip");
			zos = new ZipOutputStream(fos);
			 
			
			for(String file:filePath) {
				
				zos.putNextEntry(new ZipEntry(new File(file).getName()));
				
				 byte[] bytes = Files.readAllBytes(Paths.get(file));
				 zos.write(bytes, 0, bytes.length);
				 zos.closeEntry();
			}
			 
		}
		catch (Exception e) {
				
			e.printStackTrace();
		}
		finally{
			
			try {
				if(zos!=null) {
					
					zos.close();
					System.out.println("Done.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	
}
