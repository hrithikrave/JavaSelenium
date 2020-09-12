package classwork.pom.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





public class SampleAppSuite2 {
	public WebDriver driver;
	String browser = "chrome";
	String url = "http://automationpractice.com/";
	
	
	@BeforeClass
	public void bfClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		

		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FireFox browser Launched");
			
	} else {
				
		driver = new ChromeDriver();
		System.out.println("Chrome browser Launched");
				
	}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
	}
	
	@Test(priority = 1, dataProvider = "readData", dataProviderClass = ExcelDataProvider.class )
	public void excelExtract(String Dress, String email) throws Exception {
		Thread.sleep(2000);
		WebElement sInput =driver.findElement(By.xpath("//input[@id='search_query_top']"));
		sInput.clear();
		sInput.sendKeys(Dress);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		System.out.println("Search Successful");
		driver.findElement(By.xpath("//a[normalize-space(.)='Sign in']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(email);
		System.out.println("Email ID entered : "+email);
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
		
		Thread.sleep(1000);
		
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
		System.out.println("Closed the browser");
	}
	
	

		
}

