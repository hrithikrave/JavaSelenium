package classwork.pom.testsuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CreateActPage {
	
WebDriver driver;
Logger log;
	public CreateActPage (WebDriver d) {
		driver = d;
		
		
	}
	
	// emailEntry field
	@FindBy(xpath="//input[@id='email_create']")
	WebElement eMailEntry;
	
	// Create Account button
	@FindBy(xpath= "//button[@id='SubmitCreate']")
	WebElement createActBtn;
	
	public boolean createAcct (String emailID)	{
		
		if(!eMailEntry.isDisplayed()) {
			System.out.println("eMail id field not displayed");
			return false;
		}
		
		eMailEntry.click();
		log.info("eMailEntry.click()");
		eMailEntry.clear();
		log.info("eMailEntry.clear()");
		eMailEntry.sendKeys(emailID);
		log.info("eMailEntry.sendKeys(emailID)");
		System.out.println(emailID + " Email ID entered");
		createActBtn.click();		
		System.out.println("Clicked on create Account button");
		return true;
		
	}    
	
	

	@BeforeMethod
	public void initiateLog(Method m) throws Exception, IOException {
		String filename = m.getName();
		String logpath = ".\\logs\\" + filename + ".txt";
		log = Logger.getLogger(logpath);
		FileHandler handler = new FileHandler(logpath);
		log.addHandler(handler);
		log.setLevel(Level.ALL);
		handler.setFormatter(new SimpleFormatter());
		
	}
	
	@AfterMethod
	public void releaseHandler() {
	
		for(Handler h:log.getHandlers()) {
			h.close();
		} }
	  
	

}
