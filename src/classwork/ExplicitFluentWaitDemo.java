package classwork;

import java.time.Duration;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ExplicitFluentWaitDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {

		
		ExplicitFluentWaitDemo obj = new ExplicitFluentWaitDemo ();
		
		
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.fluentWait();
		obj.quitBrowser();
		
	}

	public void fluentWait() {
		
	/*
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
									   .withTimeout(Duration.ofSeconds(60))
									   .pollingEvery(Duration.ofSeconds(10))
									   .ignoring(NoSuchElementException.class);
			
	
		
	WebElement searcInput = fwait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								WebElement e = driver.findElement((By.xpath(search)));
								return e;
							}
	});
	
	searcInput.sendKeys("Casual Dress");
	System.out.println("Entered value");
	WebElement searcBtn = fwait.until(new Function<WebDriver, WebElement>() {
		public WebElement apply(WebDriver driver) {
			WebElement e = driver.findElement((By.xpath(sbtn)));
			return e;
		}
	
	});
	
	searcBtn.click();
	System.out.println("click button");
	*/
	
		String search = "//input[@id=\"search_query_top\"]";
		String sbtn ="//*[@id=\"searchbox\"]/button";
		
		WebElement searchInput = applyFluentWait(search,30,5);
		searchInput.sendKeys("Casual Dress");
		System.out.println("Entered value");
		WebElement searcBtn = applyFluentWait(sbtn,30,5);
		searcBtn.click();
		System.out.println("click button");
		
	}
	// Fluent Wait Method
	public WebElement applyFluentWait(String elexpath, long waittime, long polltime) {
	
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				   .withTimeout(Duration.ofSeconds(waittime))
				   .pollingEvery(Duration.ofSeconds(polltime))
				   .ignoring(NoSuchElementException.class);
		
		WebElement element = fwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement e = driver.findElement((By.xpath(elexpath)));
				return e;
			}
});

		return element;
	}
	
	
}