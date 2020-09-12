package classwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsingManageOptions {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\VED\\Downloads\\selenium\\Software\\DriverExtensions\\geckodriver.exe");
		
		WebDriver driver;
		
		String browser = "Chrome";
		
				
		if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				
		} else {
					
			driver = new ChromeDriver();
					
		} 
		
		driver.get("http://www.apple.com");
		
		Thread.sleep(3000);
		System.out.println("Size of cookies :" +driver.manage().getCookies().size());
		System.out.println("No. of cookies :" +driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		System.out.println("No. of cookies after delete coookies:" +driver.manage().getCookies());
		System.out.println("Size of cookies :" +driver.manage().getCookies().size());
		
		Thread.sleep(3000);

		System.out.println("Window Height :" +driver.manage().window().getSize().getHeight());
		System.out.println("Windor Width : " +driver.manage().window().getSize().getWidth());
		
		System.out.println("X: "+driver.manage().window().getPosition().getX());		
		System.out.println("Y: "+driver.manage().window().getPosition().getY());
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().window().fullscreen();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Window Height :" +driver.manage().window().getSize().getHeight());
		System.out.println("Windor Width : " +driver.manage().window().getSize().getWidth());
		Point point = new Point(234, 456);
		driver.manage().window().setPosition(point);
		Thread.sleep(3000);
		Dimension dim = new Dimension (450, 300);
		driver.manage().window().setSize(dim);
	//	Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		
		
		driver.quit();
	}
	

}
