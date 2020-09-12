package classwork;

import org.openqa.selenium.By;

public class FramesDemo extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FramesDemo obj = new FramesDemo();
		obj.launch("Chrome", "https://jqueryui.com/selectmenu/");
		obj.framesJqueryDemo();
		obj.quitBrowser(); 

	}
	public void framesJqueryDemo() throws Exception {
	
	driver.switchTo().frame(0);
	String dropdnXpath = "//span[@id='speed-button']/span[2]";
	String drodnMnXpath = "//ul[@id=\"speed-menu\"]/li/div[text()='%r%']";  // %r% --> dynamic value
	
	driver.findElement(By.xpath(dropdnXpath)).click();
	driver.findElement(By.xpath(drodnMnXpath.replace("%r%", "Medium"))).click();
	Thread.sleep(3000);
	System.out.println("Medium Selected");
	driver.findElement(By.xpath(dropdnXpath)).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(drodnMnXpath.replace("%r%", "Faster"))).click();
	Thread.sleep(3000);
	System.out.println("Faster Selected");
	
	

}
}