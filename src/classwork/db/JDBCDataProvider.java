package classwork.db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;


public class JDBCDataProvider {
	    private Connection connect = null;
	    private Statement statement = null;
	    private ResultSet resultSet = null;

	    @DataProvider(name="dbData")
	    public String[][] readDataBase() throws Exception {
	    	String[][] dataArray;
	        try {
	            /* This will load the MySQL driver */
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            /* Setup the connection with the DB */
	            connect = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","Ravi0425");
	            /* Statements allow to issue SQL queries to the database */
	            statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	            /* Result set get the result of the SQL query */
	            resultSet = statement.executeQuery("select * from dressemail");
	            /* Get Number of Rows and Columns*/
	            resultSet.last();  //Move to last row
	            int rows = resultSet.getRow(); // No.of Rows
	            System.out.println("No.of Rows:" + rows);
	            int cols = resultSet.getMetaData().getColumnCount(); // No.of Columns in the table
	            System.out.println("No.of Cols:" + cols);
	            /* Declare size of return values of 2D array*/
	            dataArray = new String[rows][cols];
	            int r = 0;
	            int j = 0;
	            /* Read Result Set into Double Dimension array*/
	            resultSet.beforeFirst(); //Move control to first row
	            while (resultSet.next()) {
	                String SString = resultSet.getString("dress");
	                String eString = resultSet.getString("email");		               
	                System.out.println("Search String: " + SString);
	                System.out.println("Email String: " + eString);
	                dataArray[r][0]=SString; // [0][0], [1][0]. [2][0], [3][0]
	                dataArray[j][1]=eString;
	                r++; //1
	                j++;
	                
	            }
	            
	    } catch (Exception e) {
	     throw e;
	    } finally {
	      close();
	    }
        /* Return Data*/
        return dataArray;
	
     }
	    
	    /* Close all DB Objects */    
        private void close() {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
        }
}

