package classwork.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

public class JDBCDataProviderINT {
	
	
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	@DataProvider(name="dbData")
	public String[][] readDB() throws Exception {
		 String [][]  dataArray;
		
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 connect = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","Ravi0425");
		 statement = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 resultset = statement.executeQuery("Select * from dressemail");
		 
		 resultset.last();
		 int row = resultset.getRow();
		 System.out.println("Number of rows :"+row);
		 int col = resultset.getMetaData().getColumnCount();
		 System.out.println("Number of columns :"+col);
		 
		 dataArray = new String[row][col];
	     	 
		 int r = 0;
		 int c = 0;
		 resultset.beforeFirst();
		 
		 while(resultset.next()) {
			 String searchStr = resultset.getString("dress");
			 String emailStr = resultset.getString("email");
			 
			 System.out.println("search val :"+searchStr);
			 System.out.println("email val :"+emailStr);
			 
			 dataArray[r][0] = searchStr;
			 dataArray[c][1] = emailStr;
			 r++;
			 c++;
				
	}} catch (Exception e) {
		 throw e;
	} finally {
		close();
	}
	
		 return dataArray;
}
	
	public void close ()  {
		try {
		
		if (resultset != null) {
		
				resultset.close();
			} 
		
		if (statement != null) {
			
			statement.close();
		}
		
		if (connect !=null) {
			connect.close();
		}
		
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
