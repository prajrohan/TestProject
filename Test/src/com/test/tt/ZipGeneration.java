package com.test.tt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.zeroturnaround.zip.ZipUtil;

import com.itextpdf.io.util.FileUtil;

public class ZipGeneration {

	public static void main(String[] args) {
		
		ZipGeneration zp = new ZipGeneration();
		
		zp.zipGeneration("bangalore","chennai","TouringTalkies","501","malleshwaram");
	}
	
	
	public void zipGeneration(String source,String destination,String operator,String routeNum,String stopname) {
		
		ZipOutputStream zos = null;
		
		try {
			String pathfrom = "c:/var/www/html/gps/efe/system32";
			String pathTo = "c:/var/www/html/gps/operator/"+operator+"/efe/system32";

			File dir1 = new File(pathTo);
			
			if(!dir1.exists()) {
				
				dir1.mkdirs();
			}

			String autoAnnouncementDir = pathfrom+File.separator+"announcementGPS"+File.separator+operator;
			String destinationDir = pathfrom + File.separator +"destination";
			String manualAnnoucementDir = pathfrom + File.separator + "manualAnnoucement";
			String generalMessagesDir = pathfrom + File.separator + "generalMessages/operator"+File.separator+operator;
			String breakfastDir = pathfrom + File.separator + "breakfast";
			String breaksDir = pathfrom + File.separator + "break";
			String lunchDir = pathfrom + File.separator + "lunch";
			String dinnerDir = pathfrom + File.separator + "dinner";
			String restroomDir = pathfrom + File.separator + "restroom";
			String onRouteDir = pathfrom + File.separator + "onRoute";
			String singleMp3Dir = pathfrom + File.separator + "singleMp3";
			String passingDir = pathfrom + File.separator + "passing";
			
			ArrayList<String>path = new ArrayList<String>();
			
			path.add(autoAnnouncementDir);
			path.add(destinationDir);
			path.add(manualAnnoucementDir);
			path.add(generalMessagesDir);
			path.add(breakfastDir);
			path.add(breaksDir);
			path.add(lunchDir);
			path.add(dinnerDir);
			path.add(restroomDir);
			path.add(onRouteDir);
			path.add(singleMp3Dir);
			path.add(passingDir);
			
			for(String s:path) {
				
				File dir = new File(s);
				
				File files [] = dir.listFiles();
				
				for(File f : files) {
					
					if(f.getName().startsWith(source) || f.getName().startsWith(destination)) {

						if(s.contains("announcementGPS")) {
							
							FileUtils.copyFile(f.getAbsoluteFile(), new File(pathTo+File.separator+"announcementGPS"+File.separator+f.getName()));
						}
						else if(s.contains("destination")) {
							
							FileUtils.copyFile(f.getAbsoluteFile(), new File(pathTo+File.separator+"destination"+File.separator+f.getName()));
						}
					}

				if(s.contains("manualAnnoucement")) {
						
						if(f.getName().equals("manualLangAudio")) {
							
							File [] dirs = f.listFiles();
							
							for(File a:dirs) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"manualAnnoucement/manualLangAudio/"+a.getName()));
							}
							
						}
						if(f.getName().equals("manualRouteAudio") || f.getName().equals("stopNames")) {
							
							File [] dirs = f.listFiles();
							
							for(File a:dirs) {

								
								if(a.getName().startsWith(routeNum)) {
									
									FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"manualAnnoucement/manualRouteAudio/"+a.getName()));
									
								}
								
								else if(a.getName().equals(operator)) {
									
									File [] operatordirs = a.listFiles();
									
									for(File od: operatordirs) {
										
										if(od.getName().startsWith(routeNum)) {
											
											FileUtils.copyFile(od.getAbsoluteFile(), new File(pathTo+File.separator+"manualAnnoucement/stopNames/"+operator+"/"+od.getName()));
											
										}			
									}
								}
							}
							
						}
					}
			if(s.contains("generalMessages") || s.endsWith("break") || s.contains("lunch") || s.contains("dinner") || s.contains("restroom") || s.endsWith("fast")) {
					
					File [] dirs = f.listFiles();
					
					for(File a:dirs) {
						
						if(a.getName().startsWith(stopname)) {
	
							if(s.contains("generalMessages")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"generalMessages/"+operator+File.separator+f.getName()+File.separator+a.getName()));
							}
							else if(s.endsWith("break")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"break"+File.separator+f.getName()+File.separator+a.getName()));
							}
							else if(s.contains("lunch")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"lunch"+File.separator+f.getName()+File.separator+a.getName()));
							}
							else if(s.contains("dinner")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"dinner"+File.separator+f.getName()+File.separator+a.getName()));
							}
							else if(s.contains("restroom")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"restroom"+File.separator+f.getName()+File.separator+a.getName()));
							}
							else if(s.endsWith("fast")) {
								
								FileUtils.copyFile(a.getAbsoluteFile(), new File(pathTo+File.separator+"breakfast"+File.separator+f.getName()+File.separator+a.getName()));
							}
							
							
							}
						}
					}
			
				if(s.contains("onRoute") || s.contains("passing") || s.contains("singleMp3")) {
					
					if(f.getName().equals(source) || f.getName().equals(destination)) {
					
						File [] dirs = f.listFiles();
						
						for(File a:dirs) {
	
							File [] langDir = a.listFiles();
						
							for(File lang:langDir) {
								
								if(lang.getName().startsWith(stopname)){
									
									System.out.println(lang.getName());
									
									if(s.contains("onRoute")) {
										
										FileUtils.copyFile(lang.getAbsoluteFile(), new File(pathTo+File.separator+"onRoute"+File.separator+f.getName()+File.separator+a.getName()+File.separator+lang.getName()));
									}

									else if(s.contains("passing")) {
										
										FileUtils.copyFile(lang.getAbsoluteFile(), new File(pathTo+File.separator+"passing"+File.separator+f.getName()+File.separator+a.getName()+File.separator+lang.getName()));
									}
									else if(s.contains("singleMp3")) {
										
										FileUtils.copyFile(lang.getAbsoluteFile(), new File(pathTo+File.separator+"singleMp3"+File.separator+f.getName()+File.separator+a.getName()+File.separator+lang.getName()));
									}
									
								}
					
							}
							
						}
						
					}
				}
			
			
				}
				
			}
	
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			if(zos!=null) {
				
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	
		}
	}
	
}
