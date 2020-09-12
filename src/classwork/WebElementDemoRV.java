package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementDemoRV extends LaunchBase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		WebElementDemoRV obj = new WebElementDemoRV ();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
	
		obj.webElle();				
		obj.quitBrowser();
	}
	
	public void webElle() throws Exception {
		
		
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		Thread.sleep(3000);
		System.out.println("Size of cookies :" +driver.manage().getCookies().size());
		System.out.println("No. of cookies :" +driver.manage().getCookies());
		driver.manage().deleteAllCookies();
		System.out.println("No. of cookies after delete coookies:" +driver.manage().getCookies());
		System.out.println("Size of cookies :" +driver.manage().getCookies().size());
		Thread.sleep(3000);  

	//	WebElement Searchbtn = driver.findElement(By.tagName("button"));
	//	Searchbtn.click();
		driver.findElement(By.id("search_query_top")).sendKeys("Summer Dress");
		System.out.println("Input Summer Dress");
		System.out.println(driver.findElements(By.tagName("button")).size());
		
		driver.findElements(By.tagName("button")).get(0).click();
		System.out.println("CLicked the button index 0");
		
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a"));
		
	}
}
