package classwork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CssDemo extends LaunchBase {

	public static void main(String[] args) throws Exception {

		
		CssDemo obj = new CssDemo ();
		obj.launch("Chrome", "http://automationpractice.com/index.php");
		obj.cssUsage();
		obj.quitBrowser();
	}
	
	public void cssUsage() throws Exception {
		
		String searchCss = "input#search_query_top";  // Using ID  --> Syntax # for ID
		String searchCss2 = "input.search_query";     // Using Class  --> Syntax .for Class
		String searchCss3 = "input[placeholder='Search']" ; 	//Using anything --> Syntax input[]
		String searchCss4 = "input[placeholder='Search'][name ='search_query']" ;  // as my as attributes --> Syntax input[][]
				
		String button1 = "button.btn[type='submit'][name ='submit_search']";  // using class and attribute
		
		String contact = "a[title='Contact Us']";  //
		String searchPrefix = "input[name^=search]";  // Starts with
		String searchSuffix = "input[name$=query]";  // ends with
		String searchSubstring = "input[name*=_que]";  // contains
		
		String parent = "form > button";  // using Parent
		String grandparent = "div > form > button"; // using grandparent
		String skipparent = "div button[name='submit_search']"; //using grandparent grand child and another atrribute
		String siblings = "form input + input +input + input"; //using siblings
		String nthChild = "form > input:nth-child(4)"; // using nth child
		
		
		driver.findElement((By.cssSelector(nthChild))).sendKeys("Summer Dress");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(button1)).click();		
		Thread.sleep(5000);
		
	}

}

