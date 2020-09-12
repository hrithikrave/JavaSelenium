package classwork.pom.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoPracHomePage {
	
	WebDriver driver;
	
	public AutoPracHomePage (WebDriver d) {
		driver = d;
		
	}
	
	// Search Input field
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchInput;
	
	// Search button next to search field
	@FindBy(xpath ="//button[@name='submit_search']")
	WebElement searchButton;
	
	// Signin button
	@FindBy(xpath="//a[normalize-space(.)='Sign in']")
	WebElement signInbtn;
	
	// multiple input list
	@FindBy(xpath="//input")
	List<WebElement> inputList;
	
	
	// Popular button on Home Page
	@FindBy(xpath = "//a[normalize-space(.)='Popular']")
	WebElement popularBtn;
	
	public void launchBrowserURl(String browser, String url) throws Exception {
		
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
	
	
	}
	
	public boolean homePage() {
		
	if(!popularBtn.isDisplayed()) {
		System.out.println("Automation Practice home page not displayed");
		return false;
	} else {
		System.out.println("Automation Practice home page  displayed");
		return true;
			}	
	}
	
	public boolean enterSearch (String Dress) {
		if(!searchInput.isDisplayed()) {
		System.out.println("Search Input not displayed");
		return false;
		
	} 
		
	//	searchInput.click();
	//	searchInput.clear();
		searchInput.sendKeys(Dress);
		System.out.println("Entered " +Dress +"in Search");
		searchButton.click();
		return true;
	
		
}
	/**
	 * method for Signin button click
	 * @return button visible  
	 */
	public String clickOnSignIn () {
		if(!signInbtn.isDisplayed()) {
			return "SignIn button not displayed";
			
		
	} else 
		
		signInbtn.click();
		System.out.println("Clicked on Signin button");
		return "";
	}	
	
	
	/**
	 * method to display number of input fields in page
	 */
	public void inputFields () {
		System.out.println("No. of inputs :" +inputList.size());
	}

}


