package com.test.tt;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfDemo1 {

	
	public static void main(String[] args) {
		
		 String pdfFilename = "PDF_1.pdf";
		 PdfDemo1 pd = new PdfDemo1();
		 pd.createPDF(pdfFilename);
		
	}
	
	
	 private void createPDF (String pdfFilename){
		 
		  Document doc = new Document();
		  PdfWriter docWriter = null;
		 
		  try {
		    
		   //special font sizes
		   Font mainHeading = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.BOLD, BaseColor.BLUE);
		   Font colHeading = new Font(FontFamily.TIMES_ROMAN, 9, Font.BOLD, BaseColor.RED); 
		   Font content = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD, BaseColor.BLACK);
		 
		   //file path
		   String path = "d:/" + pdfFilename;
		   docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
		    
		   //document header attributes
		   doc.addTitle("Manual Announcement");
		   doc.setPageSize(PageSize.LETTER);
		   
		   //open document
		   doc.open();
		 
		    
		   //specify column widths
		   float[] columnWidths = {1f, 4f, 0.5f, 1f, 4f};
		   //create PDF table with the given widths
		   PdfPTable table = new PdfPTable(columnWidths);
		   // set table width a percentage of the page width
		   table.setWidthPercentage(105f);
		 
		   //insert column headings
		   insertCell(table, "TouringTalkies Manual Announcement", Element.ALIGN_CENTER, 5,  mainHeading);
		   insertCell(table, "581 : Bangalore - Tirchy", Element.ALIGN_CENTER, 5,  mainHeading);


	
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

				int num = 0;
				int num1 = 40;
				
				int size;
				if(map1.size() > map.size()) {
					
					size = map1.size();
				}else {
					
					size = map.size();
				}
				
				for(int i=0;i<size;i++,num++,num1++) {
					
					String gen = map.get(i);
					String places = map1.get(i);

					if(gen == null) {
						
						gen = " "; 
					}
					else if(places == null){
						
						places = " ";
					}

							if(gen.equals("General Annoucement") || gen.equals("Break Fast") || gen.equals("Lunch") || gen.equals("Dinner") || gen.equals("Break") || gen.equals("Restroom/Toilet")) {
								insertCell(table, "Sl.no", Element.ALIGN_CENTER, 1, colHeading);
								insertCell(table, gen, Element.ALIGN_CENTER, 1, colHeading);
							}
							else {
								insertCell(table, Integer.toString(num), Element.ALIGN_CENTER, 1, content);
								insertCell(table, gen, Element.ALIGN_LEFT, 1, content);
							}
						
							insertCell(table, " ",Element.ALIGN_LEFT, 1, content);
							
							if(places.equals("On Route Announcement") || places.equals("Chennai Drop Points") || places.equals("Goa Drop Points")) {
								
								insertCell(table, "Sl.no", Element.ALIGN_CENTER, 1, colHeading);
								insertCell(table, places, Element.ALIGN_CENTER, 1, colHeading);
								
							}
							else {
								
								insertCell(table, Integer.toString(num1), Element.ALIGN_CENTER, 1, content);
								insertCell(table, places,Element.ALIGN_LEFT, 1, content);
							}
							
							if(gen.equals("Break Fast")) {
								num = 10;
							}
							if(gen.equals("Lunch")) {
								num = 16;
							}
							if(gen.equals("Dinner")) {
								num = 22;
							}
							if(gen.equals("Break")) {
								
								num = 30;
							}
							if(gen.equals("Restroom/Toilet")) {
								
								num = 34;
							}
							if(places.equals("Goa Drop Points")) {
								
								num1 = 60;
							}
							if(places.equals("Chennai Drop Points")) {
								
								num1 = 80;
							}
							
						
				}
 
		   doc.add(table);
		 
		  }
		  catch (Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		  finally
		  {
		   if (doc != null){
		    //close the document
		    doc.close();
		   }
		   if (docWriter != null){
		    //close the writer
		    docWriter.close();
		   }
		  }
		 }
		  
		 private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		  //set the cell alignment
		  cell.setHorizontalAlignment(align);
		  //set the cell column span in case you want to merge two or more cells
		  cell.setColspan(colspan);
		  //in case there is no text and you wan to create an empty row
		  if(text.trim().equalsIgnoreCase("")){
		   cell.setMinimumHeight(10f);
		  }
		  //add the call to the table
		  table.addCell(cell);
		   
		 }
	
}
