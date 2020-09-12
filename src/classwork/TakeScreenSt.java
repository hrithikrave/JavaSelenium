package classwork;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenSt {

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		Date today = new Date();
		String formatter1 = new SimpleDateFormat ("'Screenshot'hhmmss'.jpg'").format(today);		
		//lwe.createDirectory1();
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Path srcFilePath = Paths.get(scrFile.getAbsolutePath());
		Path destDir = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Run122145\\1.png");
		Files.copy(srcFilePath, destDir, StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println(srcFilePath+formatter1);
		
		
		
	}
}
