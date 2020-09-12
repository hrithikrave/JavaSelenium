package exerciseSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import classwork.LaunchBase;

public class FramesExercise extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FramesExercise obj = new FramesExercise();
		obj.launch("Chrome", "https://www.selenium.dev/selenium/docs/api/java/index.html");
		obj.framesXpath();
		obj.quitBrowser();
			
	}
	
	public void framesXpath () throws Exception {
		
		driver.switchTo().frame("packageListFrame");
	/*	String pname = "/html/body/div[3]/table/caption/span[1]";
		Boolean pb = driver.findElement(By.xpath(pname)).isDisplayed();
		String pb1 =	driver.findElement(By.xpath(pname)).getAttribute("text");
		String pb2 =	driver.findElement(By.xpath(pname)).getText();	
		System.out.println(pb1);
		System.out.println(pb2); 
		*/
	
		System.out.println("Switched to Fame 1 successfully");
		

		driver.findElement(By.xpath("//html/body/div[2]/ul/li[1]/a[text()='com.thoughtworks.selenium']")).isDisplayed();
		
		String p1 = driver.findElement(By.xpath("//html/body/div[2]/ul/li[1]/a[text()='com.thoughtworks.selenium']")).getText();
		System.out.println(p1);
		
		driver.findElement(By.xpath("//html/body/div[2]/ul/li[1]/a[text()='com.thoughtworks.selenium']")).click();
		Thread.sleep(3000);
		System.out.println("Clicked link in Frame 1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		System.out.println("Switched to Fame 2 successfully");
	/*	String f2 ="/html/body/div/h2[1][text()='Interfaces']";
		driver.findElement(By.xpath(f2)).isDisplayed();
		String fb2 = driver.findElement(By.xpath(f2)).getText();	
		System.out.println(fb2);  */
		Thread.sleep(3000);
		
		String F21 = "/html/body/div/ul[1]/li[1]/a/span";
		driver.findElement(By.xpath(F21)).isDisplayed();	
		driver.findElement(By.xpath(F21)).click();	
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		
		String F3 = "/html/body/div[3]/h2";
		driver.findElement(By.xpath(F3)).isDisplayed();
		String F31 =	driver.findElement(By.xpath(F3)).getText();	
		System.out.println(F31);
		
		if(F31.equalsIgnoreCase("Interface CommandProcessor")) {
			System.out.println("program successfully processed");
			}
			else { 
				System.out.println("program failed");
			
		
		}
		
		
		
	}
	
	}


