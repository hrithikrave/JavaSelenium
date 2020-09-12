package classwork;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDirectory {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		createDirectory1();

	}
	
	public static void createDirectory1 () throws Exception {
		
		Date today = new Date();
		String f1 = new SimpleDateFormat ("'RunCD'hhmmss").format(today);	
		System.out.println(f1);
		Path directory = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\"+f1);
//		Files.createDirectory(directory);
		
		System.out.println("Get path of index :" +directory.getName(7));
		System.out.println("get path 1: "+directory.getFileName());
		System.out.println("get path 2: "+directory.getName(6));
		System.out.println(directory);
		
	}

}
