package exerciseSelenium.pom;

import java.io.IOException;

public class ReadExcelData {

	  public static void main(String[] args) {
	    try {
	      ExcelOperationUsingPoi.readExcel("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium", "ReadUsingPOI.xlsx", "Demographics");
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	  }
	}
