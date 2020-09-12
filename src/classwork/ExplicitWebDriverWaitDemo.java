package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWebDriverWaitDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {

		
		ExplicitWebDriverWaitDemo obj = new ExplicitWebDriverWaitDemo ();
		
		
		obj.launch("Chrome", "http://automationpractice.com/index.php");
	//	obj.explicitWait("//img[@src='http://automationpractice.com/modules/homeslider/images/sample-3.jpg']");
		obj.explicitWait();
		obj.quitBrowser();
		
		
	}	
		public void explicitWait() throws Exception {
					
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		WebDriverWait eWait = new WebDriverWait(driver, 60);  // 45 is 45 seconds
		WebElement Img3 = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/modules/homeslider/images/sample-1.jpg']"));
		
		Boolean Rt = eWait.until(ExpectedConditions.invisibilityOf(Img3));
		
		
		if(Rt !=null) {
			
		System.out.println("Image visible");
				
		} else {
			System.out.println("Image not Visible");
		}
		
		//flashing
		WebElement phonei = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/span/i"));
		// flashing
	//	JavaScriptUtil.flash(phonei, driver);
	//	Thread.sleep(2000);
		
		//highlight
		JavaScriptUtil.drawBorder(phonei, driver);
		Thread.sleep(2000);
	
		boolean phonebtn =eWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/span/i"))) != null;
		
		
		if(phonebtn) {
		System.out.println("phone button  clickable");
			
		} else {
		System.out.println("phone button not clickable");
		}
			
		// populate alert message 		
	//	JavaScriptUtil.generateAlert(driver, "This is a alert message passed in runtime");
	//	Thread.sleep(2000);	
		
		boolean mapicon =eWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"block_contact_infos\"]/div/ul/li[1]/i"))) != null;
		
		if(mapicon) {
		System.out.println("Map Icon clickable");
			
		} else {
		System.out.println("Map Icon  not clickable");
		}
		
		
		if 
		(eWait.until(ExpectedConditions.titleContains("Store"))) {
		
		
		System.out.println("Title Text correct");
			
		} else {
		System.out.println("Title Text incorrect");
		}
		
		
			
		}
		}
		
		

	
