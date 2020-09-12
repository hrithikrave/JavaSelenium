package classwork;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	//Flashing
	public static void flash (WebElement element, WebDriver driver) {
	
		
		
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i=0; i<10; i++) {
			changeColor("#008888", element, driver);
			changeColor(bgcolor, element, driver);
		}
			
		
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+ color + "'", element);
		
		try {
			
			Thread.sleep(200);
			}
		catch (InterruptedException e) {
		}
			
	}
	
	//Highlight
	public static void drawBorder(WebElement element, WebDriver driver) {
	JavascriptExecutor js =  ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].style.border ='3px solid red'", element);
		
	}
	
	//Generate Alert
	public static void generateAlert(WebDriver driver, String message) {
	JavascriptExecutor js =  ((JavascriptExecutor)driver);
	js.executeScript("alert('" + message + "')");
	
		
	}

}


