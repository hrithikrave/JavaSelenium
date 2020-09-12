package classwork.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Grid_File1 {
	//WebDriver driver ;
	String baseURL = "http://automationpractice.com/index.php";
	WebDriver driver;
	String browser = "firefox";
	String hubUrl = "http://localhost:4444/wd/hub";
	/* Login Page Xpaths */
	String userNameXapth = "//input[@name='userName']";
	String userPwdXpath="//input[contains(@name,'password')]";
	String signInXpath= "//input[(@type='image') and (@name='login')]";
	
	@Test(priority=0)
	public void myLaunch() throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		

		 if(browser.equalsIgnoreCase("firefox")) {
		   //	 FirefoxOptions opt = new FirefoxOptions();
		   //	 driver = new RemoteWebDriver(new URL(hubUrl), opt);
			 driver = new FirefoxDriver();
		 } else if (browser.equalsIgnoreCase("chrome")) {
			// ChromeOptions opt = new ChromeOptions();
			// driver = new RemoteWebDriver(new URL(hubUrl), opt);
			 driver = new ChromeDriver();
		 } 
		  driver.get(baseURL);
		 Thread.sleep(3000);
		 System.out.println("Maximizing window");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 System.out.println("Setting temeout Settings..");
		 driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 driver.get(baseURL);
		 System.out.println(" Broswer launched for URI:"+ baseURL);
		 String getURLStr = driver.getCurrentUrl();
		 boolean rFlag = getURLStr.contains("automationpractice.com");
		 Assert.assertTrue(rFlag, "Failed to Launch");
	} 
	
	@Test(priority=5, dataProvider="readData")
	public void search(String searchStr) throws Exception {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(searchStr);
		System.out.println("Entered search string : " + searchStr);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@name='submit_search']")).click();
		System.out.println("Clicked on search button..");
		Thread.sleep(5000);
	}
	
	@Test(priority=10)
	public void quitBrowser() throws Exception{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	@DataProvider(name="readData")
	public String[][] searchDataProvider() {
		
		String searchData[][] = { {"Summer dressses"},
				                  {"Casual dresses"},
				                  {"T_Shirts"}
								};
		return searchData;
	}
	
}
