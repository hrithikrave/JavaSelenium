package classwork;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import exerciseSelenium.NestedFrame;

public class UsingActionAPI<UnhandledAlertException> extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		UsingActionAPI obj = new UsingActionAPI();
		obj.launch("Chrome", "http://demo.guru99.com/test/simple_context_menu.html");
//		obj.launch("Chrome", "http://demo.guru99.com/test/login.html");
		obj.buildActions();
//		obj.emailKeys();
		obj.quitBrowser();
			
	}
	
	public void buildActions( ) throws Exception {
	/*	
	Actions myaction0 = new Actions(driver);
	WebElement Guru = driver.findElement(By.xpath("//*[@id=\"authentication\"]/div[1]/div[1]/div[1]/div[1]/a/img"));
	Action builder0 = myaction0.click(Guru).sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().build();
	builder0.perform();
	Thread.sleep(3000);
	System.out.println("multiple tab");
	*/
		Actions myaction = new Actions(driver);
		WebElement dblclick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	
		Action builder = myaction.doubleClick(dblclick).build();
		builder.perform();
		System.out.println("Double Clicked");
		Thread.sleep(3000);
		String alt = driver.switchTo().alert().getText();
		
		
	
		if(alt.contains("You double clicked me.. Thank You..")) {
			System.out.println("Pop-up Alert displayed");
			} else
			{
			System.out.println("Pop-up Alert not displayed");
			}
		
		driver.switchTo().alert().accept();
		System.out.println("Alert Accepted");
		Actions myaction1 = new Actions(driver);
		WebElement rtclick = driver.findElement(By.xpath("/html/body/span[text()='right click me']"));
		System.out.println("Capture right click button");
		Action builder2 = myaction1.contextClick(rtclick).pause(2000).build();
		builder2.perform();
		
		
		String rttext = driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]/span")).getText();
			
		String edt = "Edit";
		if (edt.contains(rttext)) {
		
		System.out.println("Rite click value matched");
			
		} }
					
		public void emailKeys () {
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement epassword = driver.findElement(By.xpath("//input[@id='passwd']"));
		new Actions(driver).sendKeys(email,"email123@emailabc.com")
						   .pause(2000)
						   .keyDown(Keys.CONTROL)
						   .sendKeys("a")
						   .keyDown(Keys.CONTROL)
						   .sendKeys("c")
						   .pause(2000)
						   .keyUp(Keys.CONTROL)
						   .build().perform(); 
		System.out.println("Password entered using Ctrl V");
		
		
		new Actions(driver).keyDown(epassword, Keys.CONTROL)
							.sendKeys("v")
							.pause(2000)
							.build().perform(); 
System.out.println("Password entered using Ctrl V");
		
		email.clear();
		new Actions(driver).sendKeys(email,"email123@emailabc.com")
						   .pause(2000)
						   .sendKeys(Keys.chord(Keys.CONTROL,"a"))
						   .build().perform();
		
		System.out.println("email 2 entered using Chord");
	}

			
	}
	
	
