package com.test.tt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGen {

	public static void main(String[] args) {

        try {
            Document iText_Create_Table = new Document();
            PdfWriter.getInstance(iText_Create_Table, new FileOutputStream("d:/iText_Cell_Alignment_Example.pdf"));
            iText_Create_Table.open();            
            PdfPTable my_first_table = new PdfPTable(3);            
            PdfPCell table_cell;
            float widthval=75;
            table_cell=new PdfPCell(new Phrase("Cell 1 Alignment Options for PdfCell in iText. Bottom align the contents in a Cell"));
            table_cell.setFixedHeight(widthval); /* Specify Cell height using setFixedHeight Method */
            my_first_table.addCell(table_cell);            
            table_cell=new PdfPCell(new Phrase("Cell 2 We will specify some cell positions in this example. Top Align the Contents"));
            table_cell.setFixedHeight(widthval);
            my_first_table.addCell(table_cell);            
            table_cell=new PdfPCell(new Phrase("Cell 3 iText cell alignment.setting both horizontal and vertical alignment"));
            table_cell.setFixedHeight(widthval);
            table_cell.setHorizontalAlignment(Element.ALIGN_LEFT); /* Left align horizontally */
            my_first_table.addCell(table_cell);                             
            iText_Create_Table.add(my_first_table);                       
            iText_Create_Table.close();
        }
        catch (Exception i)
        {
            System.out.println(i);
        }

	}
}
