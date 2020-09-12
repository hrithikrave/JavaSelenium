package classwork;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KillingDrivers  extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		KillingDrivers obj = new KillingDrivers();
//		obj.launch("Firefox", "file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/FramesNested.html");
		obj.killBrowsers();
			
	}
	
	public void killBrowsers () throws Exception {
		
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver *32.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver *32.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		
		System.out.println("Killed Chrome and Firefox browsers and drivers");
		
	//	WebDriverWait ewait	= new WebDriverWait(driver,60);
	//	ewait.until(ExpectedConditions.visibilityOf(element));
	}

}
