package com.ee.excellentpdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class XlsxFileConvertor {

	public void convert(String fileName) throws DocumentException,
			IOException {
		File file = new File(fileName);
		FileInputStream input_document = new FileInputStream(file);
		HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);

		int i = 0;
		while (i < my_xls_workbook.getNumberOfSheets()) {
			HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(i);
			Iterator<Row> rowIterator = my_worksheet.iterator();
			Document iText_xls_2_pdf = new Document();
			PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("PDFs/"
					+ my_xls_workbook.getSheetName(i) + ".pdf"));
			iText_xls_2_pdf.open();
			// we have two columns in the Excel sheet, so we create a PDF table
			// with
			// two columns
			// Note: There are ways to make this dynamic in nature, if you want
			// to.
			PdfPTable my_table = new PdfPTable(2);
			// We will use the object below to dynamically add new data to the
			// table
			PdfPCell table_cell;
			// Loop through rows.
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						table_cell = new PdfPCell(new Phrase(
								cell.getStringCellValue()));
						my_table.addCell(table_cell);
						break;

					case Cell.CELL_TYPE_NUMERIC:
						String cellValue;
						double numericCellValue1 = cell.getNumericCellValue();
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							Date date = HSSFDateUtil
									.getJavaDate(numericCellValue1);
							String dateFormat = cell.getCellStyle()
									.getDataFormatString();
							cellValue = new CellDateFormatter(dateFormat)
									.format(date);
							System.out.println(cellValue);
						} else {

							cellValue = new Double(numericCellValue1)
									.toString();
						}
						table_cell = new PdfPCell(new Phrase(cellValue));
						my_table.addCell(table_cell);
						break;
					case Cell.CELL_TYPE_FORMULA:
						FormulaEvaluator evaluator = my_xls_workbook
								.getCreationHelper().createFormulaEvaluator();
						if (evaluator.evaluateFormulaCell(cell) == 0) {
							numericCellValue1 = cell.getNumericCellValue();
							cellValue = new Double(numericCellValue1)
									.toString();
						} else {
							cellValue = cell.getStringCellValue();
						}
						table_cell = new PdfPCell(new Phrase(cellValue));
						my_table.addCell(table_cell);
						break;
					}
				}

			}
			// Finally add the table to PDF document
			iText_xls_2_pdf.add(my_table);
			iText_xls_2_pdf.close();
			i++;
		}
		// we created our pdf file..
		input_document.close(); // close xls
	}
}
