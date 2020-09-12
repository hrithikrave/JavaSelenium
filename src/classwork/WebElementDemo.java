package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementDemo extends LaunchBase{

	public static void main(String[] args) throws Exception {
		WebElementDemo obj = new WebElementDemo();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.webEle();
		obj.quitBrowser();
	}
	
	public void webEle() throws Exception {
		//Element by Id 
		Thread.sleep(5000);
		WebElement searchInput = driver.findElement(By.id("search_query_top"));
		searchInput.clear();
		searchInput.sendKeys("Summer dresses");
		System.out.println("Entered input in search field..");
		Thread.sleep(2000);
		//Element by name/calssName/tagname
		//WebElement searchBtn = driver.findElement(By.name("submit_search"));
		//WebElement searchBtn = driver.findElement(By.className("btn"));
		WebElement searchBtn = driver.findElement(By.tagName("button"));
		
		List<WebElement> buttons = driver.findElements(By.className("btn"));
		System.out.println(buttons.size());
		buttons.get(0).click();
		System.out.println("clicked on first button");
		
//		searchBtn.click();
//		System.out.println("clicked on search button");
//		Thread.sleep(2000);
		//element by linkText and partial linkText
		WebElement contactLink = driver.findElement(By.linkText("Contact us"));
		contactLink.click();
		Thread.sleep(2000);
//		WebElement signLink = driver.findElement(By.partialLinkText("Sign"));
//		signLink.click();
		
		driver.findElement(By.partialLinkText("Sign")).click();
		
	}
	


}
