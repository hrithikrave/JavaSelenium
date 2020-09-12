package classwork.poi;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import classwork.pom.pages.LaunchBase;

public class ExcelDataProvider  extends LaunchBase {
	
	
	@DataProvider(name ="dbData")
	public String[][] readExcel() throws Exception {
   	
		XSSFWorkbook workBook = new XSSFWorkbook("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\newWorkbook.xlsx");
			
		XSSFSheet sheet = workBook.getSheet("TestData");
		
		int rowNum = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		
		int colNum = row.getPhysicalNumberOfCells();
		
			
		String[][] readData = new String[rowNum][colNum];
		
		for(int i =0; i<rowNum; i++ ) {
			row = sheet.getRow(i);
			for(int j=0; j<colNum; j++) {
			XSSFCell cell = row.getCell(j);
			String cellVal = cell.getStringCellValue();
			System.out.print(cellVal + "\t\t");
			readData[i][j] = cellVal;
			
		}
		 
			System.out.println();
	}
		workBook.close();
		return readData;
 
		
} 
	
		
		

}
