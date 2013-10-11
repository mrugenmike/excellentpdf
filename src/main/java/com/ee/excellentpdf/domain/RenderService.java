package com.ee.excellentpdf.domain;

import java.awt.Color;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class RenderService {
	

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	public List<String> renderPDF(List<SalarySlip> salarySlips) {

		List<String> filenames = new ArrayList<String>();
		try {
			for (SalarySlip salarySlip : salarySlips) {
				
			

			String filename  = salarySlip.getName();
			String[] temp = filename.split(" ");
			filenames.add(filename);
			System.out.println("temp1"+temp[0]);
			System.out.println("temp1"+temp[1]);
			
			 String FILE = "PDFs/"+temp[0]+"."+temp[1]+".pdf";
			
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addContent(document, salarySlip);
			document.close();
			
			System.out.println(filenames);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		

	}

	
	private void addContent(Document document,
			SalarySlip salarySlip) throws DocumentException {
		Anchor anchor = new Anchor("Salary Slip", catFont);
		anchor.setName("SALARY SLIP");

		createTable(document, salarySlip);

	}


	private void createTable(Document document,
			SalarySlip salarySlip) throws DocumentException {

	

			PdfPTable table = new PdfPTable(2);

			PdfPCell c1 = new PdfPCell(new Phrase("Particulars",subFont));
			 c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);

			c1 = new PdfPCell(new Phrase("Rs.",subFont));
			 c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(c1);
			

			table.addCell("Employee Name");			
			table.addCell(salarySlip.getName());

			table.addCell("Bank A/C No");
			table.addCell((salarySlip.getBankAccountNumber()).toString());

			table.addCell("Days Worked");			
			table.addCell(salarySlip.getDaysPresent().toString());

			table.addCell("Basic Pay");
			table.addCell((salarySlip.getBasic()).toString());
			
			table.addCell("HRA");
			table.addCell((salarySlip.getHra()).toString());

			table.addCell("LTA");
			table.addCell((salarySlip.getLta().toString()));
			
			table.addCell("Conveyance Allowance");
			table.addCell((salarySlip.getConveyanceAllowance()).toString());
			
			table.addCell("Net Pay");
			table.addCell((salarySlip.getMonthlyCTC()).toString());

			document.add(table);
		
	}

	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Lars Vogel");
		document.addCreator("Lars Vogel");
	}

	public static void main(String[] args) {
		ArrayList<SalarySlip> salarySlips = new ArrayList<SalarySlip>();

		Map<String, Object> mapOfCellsValue = new HashMap<String, Object>();
		mapOfCellsValue.put("Name", "Rashmi Parab");
		mapOfCellsValue.put("Basic", 400.00);
		mapOfCellsValue.put("HRA", 8000.00);
		mapOfCellsValue.put("Con Allow",800.00);
		mapOfCellsValue.put("Bank A/c No", "235326445.00");
		mapOfCellsValue.put("LTA", 8000.00);
		mapOfCellsValue.put("Monthly CTC", 346878.00);
		mapOfCellsValue.put("Days Present",35.0);

		SalarySlip salarySlip1 = new SalarySlip(mapOfCellsValue);

		salarySlips.add(salarySlip1);

		RenderService renderService = new RenderService();
		renderService.renderPDF(salarySlips);

	}
}
