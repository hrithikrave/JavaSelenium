package classwork.poi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {
	
	
	public static void main(String[] args) throws Exception {
		
		createXlsxFile();
		
	}

public static void createXlsxFile () throws Exception {
	
	String [][] dataRows = {{"Summer dress", "Aug1@test.com"},
							{"Winter dress", "Aug2@test.com"},
							{"Casual dress", "Aug3@test.com"}};
	
	
	XSSFWorkbook workBook = new XSSFWorkbook();
	XSSFSheet sheet = workBook.createSheet("TestData");
//	XSSFRow row = sheet.createRow(0);
//	XSSFCell cell = row.createCell(0);
		
	
	for(int i=0; i < dataRows.length; i++) {
		XSSFRow row = sheet.createRow(i);
		for(int j=0; j <dataRows[i].length; j++) {
			XSSFCell cell = row.createCell(j);	
			cell.setCellValue(dataRows[i][j]);
			}
			
		
	}
	
	FileOutputStream fo = new FileOutputStream(".\\newWorkbook.xlsx");
    workBook.write(fo);
    workBook.close();
    fo.close();
    System.out.println("File Created");
}

}