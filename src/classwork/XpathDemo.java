package classwork;

import org.openqa.selenium.By;

public class XpathDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		XpathDemo obj = new XpathDemo();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.XpathUsage();
		obj.quitBrowser();
		
	}
	
	public void XpathUsage () throws Exception {
		
		driver.findElement(By.xpath("//input[@type='text'][@id='search_query_top']")).sendKeys("Summer Dress");;
		System.out.println("1");
		driver.findElement(By.xpath("//button[@name='submit_search' and @type='submit' and @class='btn btn-default button-search']"));
		System.out.println("3");
		driver.findElement(By.xpath("//button[starts-with(@class,'btn') and (@name='submit_search')]"));
		System.out.println("4");
		driver.findElement(By.xpath("//button[contains(@class,'btn')][@name='submitNewsletter']"));
		System.out.println("5");
		driver.findElement(By.xpath("//a[text()='Contact us']"));
		System.out.println("6");
		driver.findElement(By.xpath("//a[.='Contact us']"));     //   . (dot) is used in replacement for text()
		System.out.println("7");
		driver.findElement((By.xpath("//input[not(@type='hidden') and not(@name='email')]"))).clear();   // 
		Thread.sleep(4000);
		driver.findElement((By.xpath("//input[not(@type='hidden') and not(@name='email')]"))).sendKeys("spring Dress");  // multiple not operators
		System.out.println("8");
		driver.findElement((By.xpath("//a[contains(text(),'Sign in')]")));    // contains 
		System.out.println("9");
		driver.findElement((By.xpath("//a[normalize-space(text()='Sign in')]")));     // Normalize Space
		System.out.println("10");
		driver.findElement((By.xpath("//input[4]"))).clear();
		Thread.sleep(4000);
		driver.findElement((By.xpath("//input[4]"))).sendKeys("Winter Dress");   // directly using Index
		System.out.println("11");
	}
	

}
