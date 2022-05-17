package launchBrowser;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {

	public static void main(String[] args) throws InterruptedException {
		// Setting Property
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\1st_Selenium\\drivers\\chromedriver.exe");
		
		//Object create of WebDriver
		WebDriver driver = new ChromeDriver(); // object varibale
		
		// go to web site
			driver.get("https://www.google.com/");
			
	    //Maximize browser		
			driver.manage().window().maximize();
			
	    // stop execution
			Thread.sleep(4000);
			
	   // close browser
			driver.close();
			
			
		

	}

}
