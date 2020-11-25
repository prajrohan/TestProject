package com.test.tt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ColspanRowspan {

	
	public static final String DEST = "d:/rowspan_colspan.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColspanRowspan().createPdf(DEST);
    }
    
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{2, 2, 2});
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Name"));
        cell.setColspan(3);
        table.addCell(cell);
        table.addCell("SURNAME");
        table.addCell("FIRST NAME");
        table.addCell("MIDDLE NAME");

        table.addCell("James");
        table.addCell("Fish");
        table.addCell("Stone");

        table.addCell("James");
        table.addCell("Fish");
        table.addCell(" ");

        document.add(table);
        document.close();
    }
    
    
}
