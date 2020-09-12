package classwork;

import java.util.Scanner;

// import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

public class LaunchURL {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		Scanner dname = new Scanner(System.in);
		System.out.println("Enter  chrome ||  firefox :");
		String str = dname.next ();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		
		WebDriver driver = null;
		
	//	String browser = "Firefox";
		
		try {
			
		
		switch (str) {
		
		case "firefox":
			
			
		driver = new FirefoxDriver();
				break;
				
		case "chrome": 
		driver = new ChromeDriver();
				break;
		default:
			System.out.println("Choose only from chrome or firefox");
				break;
		
	    /*		
		if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				
		} else {
					
			driver = new ChromeDriver();
					
		} */
			
		}
		}
		catch (Exception e) {
		System.out.println("Choose only from chrome or firefox");
	}
	
		
		driver.get("http://google.com");
		
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());
		Thread.sleep(3000);
		driver.navigate().to("http://apple.com");
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		driver.quit();
	
		}
	
	}


