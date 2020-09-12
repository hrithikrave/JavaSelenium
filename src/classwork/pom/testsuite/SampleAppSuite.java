package classwork.pom.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import classwork.pom.pages.AutoPracHomePage;
import classwork.pom.pages.CreateActPage;




public class SampleAppSuite {
	public WebDriver driver;
	String browser = "chrome";
	String url = "http://automationpractice.com/";
	AutoPracHomePage homeObj;
	CreateActPage cActObj;
	
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
	homeObj = PageFactory.initElements(driver, AutoPracHomePage.class);
	cActObj = PageFactory.initElements(driver, CreateActPage.class);
		
	}
	
	@Test(priority = 1)
	public void searchDress( ) {
		homeObj.homePage();
		boolean retFlag = homeObj.enterSearch("Summer Dress");
		assertTrue(retFlag, "Failed to search");
		System.out.println("Search Successful");
		
		
	}
	
	@Test(priority= 5)
	public void inputButtons() throws Exception {
		homeObj.inputFields();
		System.out.println("displayed input fields");
	}
	
	@Test(priority = 10)
	public void signInClick () throws Exception {
		String Rtnmsg = homeObj.clickOnSignIn();
		Assert.assertTrue(Rtnmsg.isEmpty(), Rtnmsg);
		Thread.sleep(2000);
		cActObj.createAcct("Aug292020@testmail.com");
		
		
	}
	

	@AfterClass
	public void quitBrowser() {
		driver.quit();
		System.out.println("Closed the browser");
	}
	
	

}
