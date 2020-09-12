package exerciseSelenium;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class XpathExercise extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		XpathExercise obj = new XpathExercise();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.xPathSample();
		obj.quitBrowser();
		
	}

	public void xPathSample() throws Exception {

		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		
		String nonregular1 = "//a[contains(@title,'customer') and contains(text(),'Sign in')][@rel='nofollow']";  
		
		driver.findElement(By.xpath(nonregular1)).click();
		Thread.sleep(4000);
	}

}
