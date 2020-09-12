package classwork;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBase {

	public WebDriver driver;
	public void launch (String browser, String url) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		
	//	WebDriver driver;
		
	//	 browser = "Chrome";
		
		
		
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			
	} else {
				
		driver = new ChromeDriver();
				
	}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		
	}
	
	public void quitBrowser() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}

}
