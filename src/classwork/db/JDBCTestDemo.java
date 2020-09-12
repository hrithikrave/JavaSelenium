package classwork.db;



import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import classwork.db.JDBCDataProviderINT;
import classwork.pom.pages.AutoPracHomePage;
import classwork.pom.pages.CreateActPage;

public class JDBCTestDemo {
	public WebDriver driver;
	String browser = "chrome";
	String url = "http://automationpractice.com/";
	AutoPracHomePage homeObj;
	CreateActPage cActObj;
	
	@BeforeClass
	public void bc() throws Exception {
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
		
	homeObj = PageFactory.initElements(driver, AutoPracHomePage.class);
	cActObj = PageFactory.initElements(driver, CreateActPage.class);
	homeObj.homePage();
	}
	
	@Test(priority=5, dataProvider="dbData", dataProviderClass=JDBCDataProviderINT.class)
	public void excelDemo(String Dress, String emailID) throws Exception {
		Thread.sleep(1000);	
		boolean retFlag = homeObj.enterSearch(Dress);
		assertTrue(retFlag, "Failed to search");
		System.out.println("Search Successful");
		String Rtnmsg = homeObj.clickOnSignIn(); 
		Assert.assertTrue(Rtnmsg.isEmpty(), Rtnmsg);
		Thread.sleep(2000);
		cActObj.createAcct(emailID);
		
		
	}
	
}
