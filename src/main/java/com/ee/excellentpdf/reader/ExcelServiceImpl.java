package com.ee.excellentpdf.reader;

import com.ee.excellentpdf.domain.SalarySlip;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelServiceImpl implements ExcelService {
    public List<SalarySlip> fetchSalarySlips(File excelFile) throws IOException {
        FileInputStream input_document = new FileInputStream(excelFile);
        HSSFWorkbook workBook = new HSSFWorkbook(input_document);
        final HSSFSheet masterSheet = workBook.getSheetAt(0);
        final int firstRowNum = masterSheet.getFirstRowNum();
        final HSSFRow firstRow = masterSheet.getRow(firstRowNum);
        final int lastRowNum = masterSheet.getLastRowNum();
        final Iterator<Cell> cellIterator = firstRow.cellIterator();
        final List<String> columnFields = new LinkedList<String>();
        while (cellIterator.hasNext()){
                columnFields.add(cellIterator.next().getRichStringCellValue().getString());
            }
        final LinkedList<SalarySlip>  slips = new LinkedList<SalarySlip>();
        for(int rownum = firstRowNum+1 ;rownum<=lastRowNum;rownum++){
            final HSSFRow row = masterSheet.getRow(rownum);
            final Iterator<Cell> cellIter = row.cellIterator();

            final Map<String, Object> mapOfCellsValue = new HashMap<String, Object>();
            int columnIndex = 0;
            while (cellIter.hasNext()){
                final Cell cell = cellIter.next();
                mapOfCellsValue.put(columnFields.get(cell.getColumnIndex()),getCellValue(cell));
            }
            slips.add(new SalarySlip(mapOfCellsValue));
        }

        return slips;
    }

    private Object getCellValue(Cell cell){
        final int cellType = cell.getCellType();
        switch (cellType){
            case Cell.CELL_TYPE_NUMERIC : return cell.getNumericCellValue();
            case Cell.CELL_TYPE_STRING: return  cell.getStringCellValue();
            case Cell.CELL_TYPE_FORMULA: return  (cell.getCachedFormulaResultType()==0)?cell.getNumericCellValue():cell.getStringCellValue() ;
            default: return cell.toString();
        }
    }
}
