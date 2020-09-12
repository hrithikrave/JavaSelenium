package classwork.profile;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class FFProfileFileUploadDownloadDemo {
	
	public WebDriver driver;
	
	
	@Test
	public void launch() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		
		FirefoxProfile profile = new FirefoxProfile();
        //profile.addExtension("C:\\.xpi");
		
        // Instructing firefox to use custom download location
        profile.setPreference("browser.download.folderList", 2);
 
        // Setting custom download directory
        profile.setPreference("browser.download.dir", "C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\downloads\\");
 
        // Skipping Save As dialog box for types of files with their MIME. MIME stands for Multi-purpose Internet Mail Extensions. MIME types form a standard way of classifying file types on the Internet.
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
                "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
  //      profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
  //              "multipart/*");
       
        // Creating FirefoxOptions to set profile
        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        
        // Launching browser with options
        driver = new FirefoxDriver(option);


		driver.get("file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/FileUpLoad.html");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Download Me']")).click();
		Thread.sleep(5000);
		/* Upload File */
		driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys("C:\\Users\\VED\\Downloads\\selenium\\Training Materials\\db.7z");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@name='uploadfile']")).click();
		
	}

}
