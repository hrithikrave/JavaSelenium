package exerciseSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import classwork.LaunchBase;
import classwork.WebElementDemo;

public class CssExercise extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		CssExercise obj = new CssExercise();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.cssSample();
		obj.quitBrowser();
		
	}

	public void cssSample() throws Exception {
		
		String nonregular1 = "a[rel='nofollow']";  // identify using non regular attributes (click Sign in)
		String  usingID = "input#email_create";  // identify using id  --> # enter email
		String usingChild = "div > button";  // identify using child  // create email btton
		String usingGchild = "div > span > input"; // using grandchild	select Radio button
		String nonregular2 = "input[data-validate = 'isName'][id = 'customer_firstname']"; // first name
		String usingSuffix = "input[id = 'customer_lastname']"; // last name 
		String usingPrefix = "input[value^='t1est']"; // Email ID using prefix
		String usingSubString = "input[data-validate*='sPassw']";  // Password using Substring
		String multiAttribute = "div > select[id='days']";  // date using multiple attribute  
		String usingClass = "div > select[id='months']" ; // Month using Class renamed from ID
		String multiAttribute2 = "div > select[id='years']"; // Year using gChildand multiAttribute
		String multiAttribute3 = "input[type='checkbox'][name='newsletter']"; //out Newsletter
		String multiAttribute4 = "input[type='checkbox'][id='optin']";	// Receive Offer Optin
		String multiAttribute5 = "div > p > input.form-control[id='firstname']";  //input First name in Address
		String multiAttribute6 = "div > p > input.form-control[id='lastname']";  // input Lastname
		String multiAttribute7 = "div > p + p > label[for='company']"; // company name
		String usingID2 = "input#address1";  // address line 1
		String multiAttribute8 = "input.form-control[id='address2']"; // address line 2
		String nthChild = "//input[@name='city']";  // City  
		String nonregular3 = "select[id='id_state']";  // state
		String usingID3 = "input#postcode";  // Zipcode
		String multiAttribute9 = "p > textarea[name='other']";  // Additional information
		String multiAttribute10 = "p > input[name='phone']"; // Home Phone
		String multiAttribute11 = "p > input[id='phone_mobile']"; // Mobile
		String Prefix2 = "input[Value^='My']"; // My Address
		String multiAttribute12 = "button.btn[name='submitAccount']"; //Submit Button
		
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(nonregular1)).click();  // click Sign in button
		Thread.sleep(3000);
		
		String pnXpath = "//form[@id='create-account_form']/h3";
		
		boolean PGXpath = driver.findElement(By.xpath(pnXpath)).isDisplayed();
	//	String pagename = "Create an account";
		
		try {
		if(PGXpath) {
			System.out.println("new page Create an account page displayed");
			
		}
			
		}  catch (NullPointerException e)
		
		{
			System.out.println("new page Create an account page not displayed");
		}
		
		driver.findElement((By.cssSelector(usingID))).sendKeys("tesla1@css21.com"); // enter email
		driver.findElement(By.cssSelector(usingChild)).click();  // click create email
		
		String errXpath =  "//div[@id='create_account_error']/ol/li";
		
		System.out.println(driver.findElement(By.xpath(errXpath)).isDisplayed());
		
		if(driver.findElement(By.xpath(errXpath)).isDisplayed()) {
			String erXpathone = driver.findElement(By.xpath(errXpath)).getText();
			if (erXpathone.contains("An account using this email address has already been registered. Please enter a valid password or request a new one"));
			System.out.println("email id already exists");
		} else {
			System.out.println("email id is valid");
		
		}
		
		System.out.println("Color : "+driver.findElement(By.cssSelector(usingID)).getCssValue("Color"));
		System.out.println("BG Color : "+driver.findElement(By.cssSelector(usingID)).getCssValue("Background"));
		Point locationn = driver.findElement(By.cssSelector(usingChild)).getLocation();
		System.out.println("Location X cordinates :"+locationn.getX());
		System.out.println("Location Y cordinates :"+locationn.getY());
		Thread.sleep(2000);
		Rectangle Rectanglle = driver.findElement(By.cssSelector(usingChild)).getRect();
		System.out.println("Rectangle Height :"+Rectanglle.getHeight());
		System.out.println("Rectangle Width :"+Rectanglle.getWidth());
		Thread.sleep(2000);
		Dimension Dimensn = driver.findElement(By.cssSelector(usingChild)).getSize();
		System.out.println("Dimension Height :"+Dimensn.getHeight());
		System.out.println("Dimension Width :"+Dimensn.getWidth());
		Thread.sleep(2000);
		System.out.println("Get tag name :"+driver.findElement(By.cssSelector(usingChild)).getTagName());
		Thread.sleep(2000);
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(usingGchild)).click(); // click MR. Radio button
		driver.findElement(By.cssSelector(nonregular2)).sendKeys("TestFName");  //first name
		driver.findElement(By.cssSelector(usingSuffix)).sendKeys("TestLName");  //last name
		driver.findElement(By.cssSelector(usingPrefix)).clear(); // email id field clear
		driver.findElement(By.cssSelector(usingPrefix)).sendKeys("tesla1@css21.com"); // enter email
		driver.findElement(By.cssSelector(usingSubString)).sendKeys("Test123");  //enter password
		
		Thread.sleep(9000);
		
		driver.findElement(By.cssSelector(multiAttribute)).click();
		Select val = new Select(driver.findElement(By.cssSelector(multiAttribute)));
		val.selectByIndex(5);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(usingClass)).click();
		Select val2 = new Select(driver.findElement(By.cssSelector(usingClass)));
		val2.selectByValue("5");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(multiAttribute2)).click();
		Select val3 = new Select(driver.findElement(By.cssSelector(multiAttribute2)));
		val3.selectByValue("2000"); 
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(multiAttribute3)).click(); // select checkbox
		Thread.sleep(3000);
				
		driver.findElement((By.cssSelector(multiAttribute3))).click();
		driver.findElement((By.cssSelector(multiAttribute4))).click();
		
		driver.findElement(By.cssSelector(nonregular2)).sendKeys("TestFName");  //first name
		driver.findElement(By.cssSelector(usingSuffix)).sendKeys("TestLName");  //last name
	//	driver.findElement(By.cssSelector(multiAttribute7)).sendKeys("ABCCompany");
		driver.findElement(By.cssSelector(usingID2)).sendKeys("100 Prime street");
		driver.findElement(By.xpath(nthChild)).sendKeys("Raleigh");
		driver.findElement(By.cssSelector(nonregular3)).click();
		Select val4 = new Select(driver.findElement(By.cssSelector(nonregular3)));
		val4.selectByVisibleText("North Carolina");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(usingID3)).sendKeys("27605");
		driver.findElement(By.cssSelector(multiAttribute9)).sendKeys("Text line 1 \n Text line 2\n");
		driver.findElement(By.cssSelector(multiAttribute10)).sendKeys("9192021212");
		driver.findElement(By.cssSelector(multiAttribute11)).sendKeys("9192021213");
		driver.findElement(By.cssSelector(Prefix2)).sendKeys("101 main st, Raleigh");
		driver.findElement(By.cssSelector(multiAttribute12)).click();
		
		
		System.out.println("all steps complete");
		
		
			
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		
		
		
String soXpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a";
		
		boolean soutXpath = driver.findElement(By.xpath(soXpath)).isDisplayed();
	//	String pagename = "Create an account";
		
		try {
		if(soutXpath) {
			System.out.println("Login creation successfull");
			
		}
			
		}  catch (NullPointerException e)
		
		{
			System.out.println("issue with login creation");
		}
		
			
	
	}

}
