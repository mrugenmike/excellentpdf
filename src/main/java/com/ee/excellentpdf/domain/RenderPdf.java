package com.ee.excellentpdf.domain;

import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class RenderPdf {
	
	     private static String FILE = "PDFs/FirstPdf.pdf";
		  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
		      Font.BOLD);
		  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
		      Font.NORMAL, BaseColor.RED);
		  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
		      Font.BOLD);
		  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
		      Font.BOLD);
		  
		  public static void main(String[] args) {
		    try {
		      Document document = new Document();
		      PdfWriter.getInstance(document, new FileOutputStream(FILE));
		      document.open();
		      addMetaData(document);
		     // addTitlePage(document);
		      addContent(document);
		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		
		
	}
		private static void addContent(Document document) throws DocumentException {
			Anchor anchor = new Anchor("Salary Slip", catFont);
		    anchor.setName("SALARY SLIP");
		    
		    
		    
		    createTable(document);
			
		}
		
		private static void createTable(Document document)
			      throws DocumentException {
			    PdfPTable table = new PdfPTable(3);

			    // t.setBorderColor(BaseColor.GRAY);
			    // t.setPadding(4);
			    // t.setSpacing(4);
			    // t.setBorderWidth(1);

			    PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);

			    c1 = new PdfPCell(new Phrase("Table Header 2"));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);

			    c1 = new PdfPCell(new Phrase("Table Header 3"));
			    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			    table.addCell(c1);
			    table.setHeaderRows(1);

			    table.addCell("1.0");
			    table.addCell("1.1");
			    table.addCell("1.2");
			    table.addCell("2.1");
			    table.addCell("2.2");
			    table.addCell("2.3");

			    document.add(table);

			  }
		
		private static void addMetaData(Document document) {
			document.addTitle("My first PDF");
		    document.addSubject("Using iText");
		    document.addKeywords("Java, PDF, iText");
		    document.addAuthor("Lars Vogel");
		    document.addCreator("Lars Vogel");
		}

}
