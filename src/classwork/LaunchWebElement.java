

package classwork;


import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class LaunchWebElement extends LaunchBase {

	public static void main(String[] args) throws Exception {

		
		LaunchWebElement obj = new LaunchWebElement ();
		
		obj.createDirectory();
		obj.launch("Chrome", "https://opensource-demo.orangehrmlive.com/");
		obj.webEle();
		obj.MoveScreenshots();
		obj.quitBrowser();

	}
	
	public void webEle() throws Exception {
		
			
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		
		Thread.sleep(5000);
		WebElement searchInput1 = driver.findElement(By.name("txtUsername"));
		searchInput1.clear();
		searchInput1.sendKeys("Admin");
		System.out.println("Enter value in UserName");
		WebElement searchInput2 = driver.findElement(By.name("txtPassword"));
		searchInput2.clear();
		searchInput2.sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();;
		System.out.println("Current URL :"+driver.getCurrentUrl());
		System.out.println("Get Title :" +driver.getTitle());	
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\LoginBtn.jpg");		
		driver.findElement(By.id("menu_buzz_viewBuzz")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Admin")).click();;
		Thread.sleep(2000);
		System.out.println("Clicked Admin tab");	
		driver.findElement(By.partialLinkText("Configuration")).click();;
		System.out.println("Clicked Configration under Admin");
		Thread.sleep(2000);		
		driver.findElement(By.id("menu_admin_listMailConfiguration")).click();
		System.out.println("Clicked Email config under Configration tab");
		Thread.sleep(5000);
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\COnfig.jpg");
		driver.findElement(By.linkText("Dashboard")).click();
		System.out.println("Clicked Dashboard tab");
		Thread.sleep(2000);
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\Dashboard.jpg");
		// Timesheets
		driver.findElement(By.className("quickLinkText")).click();;
		System.out.println("Clicked Timesheet ");
		Thread.sleep(2000);	
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\Timesheet.jpg");
		
		driver.findElement(By.id("MP_link")).click();;
		System.out.println("Clicked Market Place ");
		Thread.sleep(2000);	
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\MPlink.jpg");
				
//		List <WebElement> buttons = driver.findElements(By.partialLinkText("button"));
//		System.out.println(buttons.size());
	//	buttons.get(0).click();
	//s	System.out.println("Clicked button list"); 
		
		
		
		driver.findElement(By.id("welcome")).click();
		System.out.println("Clicked Welcome Admin");	
		Thread.sleep(2000);
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\WelcomeAdmin.jpg");
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		System.out.println("Clicked Logout button using linktext");
		takeScreenshot("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\Logout.jpg");
		
		
				
	}

		public void takeScreenshot(String Snshot) throws Exception {
		
			Date today = new Date();
			String formatter1 = new SimpleDateFormat ("'Screenshot_'hhmmss'.jpg'").format(today);		
							
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Path srcFilePath = Paths.get(scrFile.getAbsolutePath());
		//	Path desfile = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\"+formatter1);
			Path desfile = Paths.get(Snshot);
			
		//	Files.copy(srcFilePath, desfile, StandardCopyOption.REPLACE_EXISTING);
			FileHandler.copy(scrFile, new File(Snshot));
		
			System.out.println(desfile.getFileName());
			
			
			
			
		}
		
		public  void createDirectory () throws Exception {

			
			Path directory = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp");
			
			if (Files.notExists(directory)) {			
			
			} else
			{
			Files.delete(directory);
			}
			
			Files.createDirectory(directory);					
			System.out.println(directory);
			
			
			System.out.println("Get path of index :" +directory.getName(6));
			System.out.println("get path : "+directory.getFileName());
			
			
		} 
		
		public void MoveScreenshots () throws Exception {
			Date today = new Date();
			String f1 = new SimpleDateFormat ("'Run'hhmmss").format(today);	
			Path Old = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\Temp\\");
			Path directoryNew = Paths.get("C:\\Users\\VED\\Downloads\\selenium\\Eclipse_Worksession\\JavaSelenium\\Screenshot\\"+f1);
			Files.createDirectory(directoryNew);					
			System.out.println("Test Results Path :" +directoryNew);
			
			Files.move(Old, directoryNew, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("End of program");
			
		}
		
}
