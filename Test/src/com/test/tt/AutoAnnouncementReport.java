package com.test.tt;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class AutoAnnouncementReport {

	public static void main(String[] args) {
		
		 String pdfFilename = "autoAnnoucement.pdf";
		 AutoAnnouncementReport pd = new AutoAnnouncementReport();
		 pd.createPDF(pdfFilename);
		
	}
	
	 private void createPDF (String pdfFilename){
		 
		  Document doc = new Document();
		  PdfWriter docWriter = null;
		  
		  Font mainHeading = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLUE);
		  Font colHeading = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.RED); 
		  Font content = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
		  
		   String path = "d:/" + pdfFilename;
		   
		   try {
			   
			   docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
			   
			   doc.addTitle("Auto Announcement");
			   doc.setPageSize(PageSize.LETTER_LANDSCAPE);
			   doc.open();
			   
			   float[] columnWidths = {2f,5f,1.5f,1.5f,1.5f,1.5f,1.5f,1.5f};
			   
			   PdfPTable table = new PdfPTable(columnWidths);
			   
			   table.setWidthPercentage(105f);
			   
			   insertCell(table, "TouringTalkies Auto Announcement", Element.ALIGN_CENTER, 8,  mainHeading);
			   insertCell(table, "Stop Name", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Latitude & Longitude", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Stop Type", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Stop Specs", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Ann Type", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Ann Specs", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Current Distance", Element.ALIGN_CENTER, 1, colHeading);
			   insertCell(table, "Next Distance", Element.ALIGN_CENTER, 1, colHeading);
			   
			   insertCell(table, "rajajinagar", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "12.2222,22.2222          21.2222,22.2222", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "Drop", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "Going", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "All", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "Both", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "40", Element.ALIGN_CENTER, 1, content);
			   insertCell(table, "120", Element.ALIGN_CENTER, 1, content);

			   
			   doc.add(table);
			   
		   }catch(Exception e) {
			   
			   e.printStackTrace();
			   
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
