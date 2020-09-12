package classwork;

import org.openqa.selenium.By;

import exerciseSelenium.NestedFrame;

public class DialogDemo  extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
				
		DialogDemo obj = new DialogDemo();
		obj.launch("Chrome", "file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/Dialog.html");
		obj.dialogHandle();
		obj.quitBrowser();
			
	}

		public void dialogHandle() throws Exception {
			
			String Login ="//button[@id='myBtn']";
			String UserID = "//input[@id='username']";
			String Pwd = "//input[@id='pwd']";
			String close = "//span[@class='close']";
			String logBtn = "//button[@name='Login']";
			
			driver.findElement(By.xpath(Login)).click();
			Thread.sleep(2000);
			boolean tFlag = driver.findElement(By.xpath(UserID)).isDisplayed();
			if (tFlag) {
				System.out.println("Dialog displayed");
			} else
				System.out.println("dialog not displayed");
			Thread.sleep(2000);
			driver.findElement(By.xpath(close)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Login)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserID)).sendKeys("TestLogin");
			driver.findElement(By.xpath(Pwd)).sendKeys("TestPassword");
			System.out.println("Credetials entered");
			Thread.sleep(2000);
			driver.findElement(By.xpath(logBtn)).click();
			
		}
}
