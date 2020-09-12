package classwork.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateActPage {
	
WebDriver driver;
	
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
		eMailEntry.clear();
		eMailEntry.sendKeys(emailID);
		System.out.println(emailID + " Email ID entered");
		createActBtn.click();		
		System.out.println("Clicked on create Account button");
		return true;
		
	}    
	  
	

}
