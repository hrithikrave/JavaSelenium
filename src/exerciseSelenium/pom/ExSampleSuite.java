package exerciseSelenium.pom;

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
import classwork.pom.pages.LaunchBase;
import classwork.pom.pages.LaunchURLMainMethod;




public class ExSampleSuite extends LaunchURLMainMethod {
	public WebDriver driver;
	LaunchURLMainMethod obj = new LaunchURLMainMethod();
//	String browser = "chrome";
//	String url = "http://automationpractice.com/";
	
	AutoPracHomePage homeObj;
	CreateActPage cActObj;
	
	@BeforeClass
	public void bfClass() throws Exception {
	obj.launch("chrome", "http://automationpractice.com/");	
	homeObj = PageFactory.initElements(driver, AutoPracHomePage.class);
	cActObj = PageFactory.initElements(driver, CreateActPage.class);
	
		
	}
	
	@Test(priority = 1)
	public void searchDress( ) throws Exception {
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
