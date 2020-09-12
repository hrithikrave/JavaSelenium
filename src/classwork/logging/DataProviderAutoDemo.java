package classwork.logging;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import classwork.LaunchBase;
import classwork.LaunchWebElement;


public class DataProviderAutoDemo  {

	public WebDriver driver;
	String browser = "chrome";
	String url = "http://automationpractice.com/index.php";
	LaunchWebElement obj = new LaunchWebElement();
	Logger log;
	
	public void launch (String browser, String url) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		
	
		if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			log.info("FireFox browser Launched");
			
	} else {
				
		driver = new ChromeDriver();
		log.info("Chrome browser Launched");
				
	}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Implicit wait time for 5 sec");
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		log.info("Pageload timeout 1 min");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	
	//	boolean URldata = driver.getCurrentUrl().contains("computer");
	//	Assert.assertFalse(URldata, "URL data doesn't contain computer ");
		
	//	boolean URldata1 = driver.getCurrentUrl().contains("Automation");
	//	Assert.assertTrue(URldata, "URL data doesn't contain Automation ");
		
		
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
		}
		
	}
	@Test (priority =5)
	public  void createDirectory () throws Exception {

				
				Path directory = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp");
				log.info("Temp fil created");
				if (Files.notExists(directory)) {			
					log.info("Temp file already not exist");
				} else
				{
				Files.delete(directory);
				}
				
				Files.createDirectory(directory);					
				System.out.println(directory);
				log.info("Directory created");
				
				
				System.out.println("Get path of index :" +directory.getName(6));
				System.out.println("get path : "+directory.getFileName());
				
				
			} 
	@Test (priority =1)
	public void launchBrowser()  throws Exception {
	
		launch(browser, url);
		
		
	}
	@Test (priority =25)
	public void quitbrowser () throws Exception {
	System.out.println("After Class");
	Thread.sleep(2000);
	driver.quit();
	
		
	}
	@Test (priority =10)
	public void homePage() throws Exception {
		
			
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		String Best_Sellers = "//a[@class='blockbestsellers']";
		String Sign_In = "//a[@class='login']";
		
		driver.findElement(By.xpath(Best_Sellers)).isDisplayed();
		System.out.println("Automation Practice Home page is displayed");
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\HomePage.jpg");		
		
		driver.findElement(By.xpath(Sign_In)).isDisplayed();
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\SignInButton.jpg");		
		log.info("click on sign in button");
		driver.findElement(By.xpath(Sign_In)).click();
		Thread.sleep(2000);
		System.out.println("Clicking on Sign In button");
		
			
	}
		@Test (priority =15)
		public void createaccount (String emailEntry) throws Exception {
			
			System.out.println("Current URL :"+driver.getCurrentUrl());
			System.out.println("Get Title :" +driver.getTitle());
		
			String Authentication  = "//h1[@class='page-heading']";
			driver.findElement(By.xpath(Authentication)).isDisplayed();
			System.out.println("Create Account Page Displayed");
			
			driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(emailEntry);
			System.out.println("Email ID entered : "+emailEntry);
			takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\CreateAccount.jpg");		
			
			
			driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
			System.out.println("Click on create button");
			Thread.sleep(2000);
			
		}
		@Test (priority =20)
		public void accountcreation(String FName, String LName) throws Exception {
			
		driver.findElement(By.xpath("//input[@name='id_gender'][@value='1']")).isDisplayed();
		System.out.println("Account creation page is displayed");
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\AcctCreationPage.jpg");		
		driver.findElement(By.xpath("//input[@name='id_gender'][@value='1']")).click();
		
		 driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(FName);
		 log.info("First name entered");
		 driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(LName);
		 log.info("Last name entered");
		 driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test123");
		 log.info("password entered");
		 
		 String multiAttribute = "div > select[id='days']";  // date using multiple attribute  
		 String usingClass = "div > select[id='months']" ; // Month using Class renamed from ID
		 String multiAttribute2 = "div > select[id='years']"; // Year using gChildand multiAttribute
		 String multiAttribute3 = "input[type='checkbox'][name='newsletter']"; //out Newsletter
		 String multiAttribute4 = "input[type='checkbox'][id='optin']";	// Receive Offer Optin
			
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
			
			
			String usingID2 = "input#address1";  // address line 1
			String nthChild = "//input[@name='city']";  // City  
			String nonregular3 = "select[id='id_state']";  // state
			String usingID3 = "input#postcode";  // Zipcode
			String multiAttribute9 = "p > textarea[name='other']";  // Additional information
			String multiAttribute10 = "p > input[name='phone']"; // Home Phone
			String multiAttribute11 = "p > input[id='phone_mobile']"; // Mobile
			String Prefix2 = "input[Value^='My']"; // My Address
			String multiAttribute12 = "button.btn[name='submitAccount']"; //Submit Button
			
			
			
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
			
			takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\CreationPage.jpg");		
			
			driver.findElement(By.cssSelector(multiAttribute12)).click();
						
			System.out.println("all steps complete");
			
			takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\Completion.jpg");		
			
			
		}
		
	
		public void takeScreenshot(String Snshot) throws Exception {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
			Path srcFilePath = Paths.get(scrFile.getAbsolutePath());
			Path destDir = Paths.get(Snshot);
			Files.copy(srcFilePath, destDir, StandardCopyOption.REPLACE_EXISTING);
			
			
			
		}
		

		public void moveScreenshots () throws Exception {
			Date today = new Date();
			String f1 = new SimpleDateFormat ("'Run'hhmmss").format(today);	
			Path Old = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\");
			Path directoryNew = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\"+f1);
			Files.createDirectory(directoryNew);					
			System.out.println("Test Results Path :" +directoryNew);
			
			Files.move(Old, directoryNew, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("End of program");
			
		}
		
		@DataProvider(name = "email1")
			public String[][] eMailEtry() {
				
				Date today = new Date();
				String emailEntry1 = new SimpleDateFormat ("'email'MMddhhmmss'@ravimail.com'").format(today);	
				
				String inputnames [][] =
										{{emailEntry1}
										 };
				
				return inputnames;
		}
		
		@DataProvider(name = "Demogra")
		public String[][] inputDBname() {
			String inputnames [][]=
									{{"FnameA", "LnameA"} };
			
			return inputnames;
			}
		
}
