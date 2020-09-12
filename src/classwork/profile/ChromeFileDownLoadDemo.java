package classwork.profile;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeFileDownLoadDemo {
	
	public WebDriver driver;
	
	@Test
	public void launch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
					
		// Setting new download directory path
        Map<String, Object> prefs = new HashMap<String, Object>();
         
        // Use File.separator as it will work on any OS
        prefs.put("download.default_directory",
        		"C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\downloads");

         
        // Adding capabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("/path/to/extension.crx"));
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        // Launching browser with desired capabilities
        driver= new ChromeDriver(options);
        
		driver.get("file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/FileUpLoad.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Download Me']")).click();
		Thread.sleep(5000);

		/* Upload File */
		driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys("C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32.zip");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='uploadfile']")).click();
	}
}
