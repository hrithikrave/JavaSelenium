package exerciseSelenium;

import org.openqa.selenium.By;

import classwork.LaunchBase;

public class NestedFrame extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		NestedFrame obj = new NestedFrame();
		obj.launch("Chrome", "file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/FramesNested.html");
		obj.nestedFramDemo();
		obj.quitBrowser();
			
	}
	
	public void nestedFramDemo ()	{
		
		driver.switchTo().frame("iframe1");
		System.out.println("Switched to Parent Frame - iFrame1");
		driver.switchTo().frame("iframe2");
		System.out.println("Switched to Parent Frame - iFrame2");
		driver.switchTo().frame("iframe3");
		System.out.println("Switched to Parent Frame - iFrame3");
		
		driver.findElement(By.xpath("/html/body/input[@name='userName']")).sendKeys("TestName");
		System.out.println("Entered User ID");
		driver.findElement(By.xpath("//input[@name='usePwd']")).sendKeys("Test Password");
		System.out.println("Entered Password");
		driver.switchTo().parentFrame();
		System.out.println("Switched to Parent Frame - iFrame2");
		driver.findElement(By.xpath("//button[@name='Login']")).click();	
		System.out.println("Clicked Login Button");
		driver.switchTo().defaultContent();
		System.out.println("Switched to site master");
		System.out.println("End of program");
		
		
		
	}

}
