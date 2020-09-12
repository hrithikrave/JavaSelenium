package classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import exerciseSelenium.CssExercise;

public class MultiSelectDemo extends LaunchBase {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		MultiSelectDemo obj = new MultiSelectDemo();
		
		obj.launch("Chrome", "file:///C:/Users/VED/Downloads/selenium/Training%20Materials/HTML/SelectDropdowns.html");
		obj.multiDemo();
		obj.quitBrowser(); 

	}
	public void multiDemo() throws Exception {
		
	Select spd = new Select(driver.findElement(By.xpath("//select[(@name='speed')]")));
	spd.selectByIndex(0);
	
	Select dtn = new Select(driver.findElement(By.xpath("//select[(@id='destination')]")));
	dtn.selectByValue("lv");
	Thread.sleep(3000);
	dtn.selectByValue("ca");
	Thread.sleep(3000);
		
	
	Select cars = new Select(driver.findElement(By.xpath("//select[(@name='cars')]")));
	System.out.println("Is Multiple Select :" +cars.isMultiple());
	Thread.sleep(3000);
	cars.selectByValue("Audi");
	cars.selectByValue("Volvo");
	cars.selectByVisibleText("Honda");
	Thread.sleep(4000);
	cars.deselectByVisibleText("Honda");
		
	
		
	
	}

}
