package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecuterDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {

		
		JavaScriptExecuterDemo obj = new JavaScriptExecuterDemo ();
		
		
		obj.launch("Chrome", "https://www.apple.com/");
		obj.javaScriptExe();
		obj.quitBrowser();

}

	public void javaScriptExe() throws Exception	{
		
		driver.getCurrentUrl();
		driver.getTitle();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
		// Fetch URL of page
		
		Object url = js.executeScript(("return document.URL;").toString());
		System.out.println("Site URL :"+url);
		Thread.sleep(3000);

		// Rerfreshing the Browser
        js.executeScript("history.go(0)");
        System.out.println("Page Refreshed ");
        
        //Get title of the page
        Object PageTitle = js.executeScript(("return document.title;").toString());
        System.out.println("Site Title : "+PageTitle);
        Thread.sleep(3000);
        
        //Vertical scroll down by pixels		
        js.executeScript("window.scrollBy(0,500)"); //This will scroll by 500 pixels
        Thread.sleep(3000);

        
        //Scroll down bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        
        //Scroll the page till the element is found		
        WebElement MakeYours = driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div/div/div[1]/h4"));
        js.executeScript("arguments[0].scrollIntoView();", MakeYours);
        Thread.sleep(3000);
        //Vertical up	
        js.executeScript("window.scrollBy(0,-500)"); //This will scroll by -500 pixels
        Thread.sleep(3000);

        
        //Click on an WebElement
        WebElement Schbtn = driver.findElement(By.xpath("//a[@id='ac-gn-link-search']"));
        js.executeScript("arguments[0].click();",Schbtn);
        
        System.out.println("Clicked on Webelement");
        Thread.sleep(3000);
        
     // Fetching Inner HTML from WebElement
        String Ini =  (String) js.executeScript("return arguments[0].innerHTML;", Schbtn);
        System.out.println("Inner value of HTML"+Ini);
      
        
        /*Enter value in Webelement
        WebElement EnterVal = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
        js.executeScript("arguments[0].value='ipad';", EnterVal);
        System.out.println("Entered value in Webelement");
        Thread.sleep(3000); */
        
        WebElement EnterVal = driver.findElement(By.xpath("//input[@id='ac-gn-searchform-input']"));
           
        new Actions(driver).sendKeys(EnterVal,"ipad").build().perform();
        Thread.sleep(2000);
        String te = (String) js.executeScript("return arguments[0].te;", EnterVal);
        System.out.println("Value in Webelement :"+te);
        new Actions(driver).sendKeys(EnterVal, Keys.ENTER).build().perform();
		   
        System.out.println("Entered value in Webelement");
        Thread.sleep(3000);
      
        /*
        WebElement Schbtn2 = driver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-submit\"]"));
        js.executeScript("arguments[0].click();",Schbtn2);
        System.out.println("Clicked on Webelement 2");
        Thread.sleep(3000);
      
        */
        
        
        //Read value from Webelement
        WebElement ValIn = driver.findElement(By.xpath("//input[@name='find']"));
        String text = (String) js.executeScript("return arguments[0].text;", ValIn);
        System.out.println("Value in Webelement :"+text);
        
        Thread.sleep(3000);
        ValIn.isDisplayed();
        String newVa = ValIn.getText();
        System.out.println("NewValue : "+newVa);
        
        /*Click on an WebElement	
        WebElement buy = driver.findElement(By.xpath("//a[@aria-label='Buy iPhone SE']"));
        js.executeScript("arguments[0].click();",buy); 
        
        System.out.println("Clicked on Webelement 2");
		*/
        
        // launch new site
        js.executeScript("window.location = 'http://www.google.com'");
        System.out.println("New site opened");
        Thread.sleep(4000);  
        
        
        	
		
	}
	
}