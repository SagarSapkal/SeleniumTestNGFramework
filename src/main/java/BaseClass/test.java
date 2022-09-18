package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.WorkbookDocumentImpl;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online


class test {
    
  
    public static void main(String args[]) throws IOException{
       
    	FileInputStream fil = new FileInputStream("C:\\\\Users\\\\Sagar Sapkal\\\\eclipse-workspace\\\\2022_TestNGFramework\\\\src\\\\test\\\\resources\\\\DataProvider.xlsx");
    	
    	XSSFWorkbook workbook = new XSSFWorkbook(fil);
    	XSSFSheet sheet = workbook.getSheet("Sheet1");
    	XSSFRow row= sheet.getRow(0);
    	
    	XSSFCell cell = row.createCell(0);
    	cell.setCellValue("test");
    	
    	FileOutputStream fo =new FileOutputStream("C:\\\\\\\\Users\\\\\\\\Sagar Sapkal\\\\\\\\eclipse-workspace\\\\\\\\2022_TestNGFramework\\\\\\\\src\\\\\\\\test\\\\\\\\resources\\\\\\\\DataProvider.xlsx");
		workbook.write(fo);
    	
		/*
		 * DataFormatter formatter = new DataFormatter();
		 * 
		 * String cellData = formatter.formatCellValue(cell);
		 * System.out.println(cellData);
		 */
        
        
        
        
    }

	
}