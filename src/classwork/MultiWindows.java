package classwork;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

import exerciseSelenium.NestedFrame;

public class MultiWindows  extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		
		
		MultiWindows obj = new MultiWindows();
		obj.launch("Chrome", "file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/MultiWindows.html");
		obj.multiWindowDemo();
		obj.quitBrowser();
			
	}
	
	public void multiWindowDemo() throws Exception {
		
		String Window1 = "//button[@id='nwindow1'][1]";
		String Window2 = "//button[@id='nwindow1'][2]";
		String Tab =  "//button[@id='nTab']";

			
		String winHandID = driver.getWindowHandle();
		System.out.println("Window Handle ID "+winHandID);
	
		int size = driver.getWindowHandles().size();
		System.out.println("No. of windows"+size);
		
		driver.findElement(By.xpath(Window1)).click();
		System.out.println("Clicke Window 1");
		Thread.sleep(3000);
		size = driver.getWindowHandles().size();
		System.out.println("No. of windows after 1st click"+size);
		Set <String> winHandIDs = driver.getWindowHandles();
		System.out.println("Window Handle IDs "+winHandIDs);
		Thread.sleep(2000);
		for(String winIDs :winHandIDs) {
			if (!winHandID.equalsIgnoreCase(winIDs) ) {
				System.out.println("Window ID :"+winIDs);
				driver.switchTo().window(winIDs);
				System.out.println("Switched to new Window");
				System.out.println(driver.getTitle());
				String Reqestdemo = "//button[@class='btn btn-primary font-600']";
				if(driver.findElement(By.xpath(Reqestdemo)).isDisplayed()) {
				System.out.println("Right page is displayed");
				Thread.sleep(3000);
				driver.findElement(By.xpath(Reqestdemo)).click();
				Thread.sleep(3000);
				
				
			} else {
				System.out.println("We are in wrong window");
			}
			
			driver.close();
		}
	}

		driver.switchTo().window(winHandID);
		size = driver.getWindowHandles().size();
		System.out.println("No. of windows"+size);
		driver.findElement(By.xpath(Tab));
		Thread.sleep(2000);
		size = driver.getWindowHandles().size();
		System.out.println("No. of windows"+size);
		System.out.println("Window Handle ID "+winHandID);
		driver.switchTo().window(winHandID);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Window2)).click();
		Thread.sleep(2000);
		size = driver.getWindowHandles().size();
		System.out.println("No. of windows"+size);
		
		driver.switchTo().window(winHandID);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Tab)).click();
		Thread.sleep(2000);
		size = driver.getWindowHandles().size();
		System.out.println("No. of windows"+size);
		Thread.sleep(2000);
		Set <String> winHandIDs2 = driver.getWindowHandles();
		System.out.println("Window Handle IDs "+winHandIDs2);
		Thread.sleep(2000);
		driver.switchTo().window(winHandID);
		System.out.println(driver.getCurrentUrl());
		
}
}