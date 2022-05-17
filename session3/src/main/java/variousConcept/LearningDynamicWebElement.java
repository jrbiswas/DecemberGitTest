package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningDynamicWebElement {
	
	WebDriver driver;
	
	

 @Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", " .\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",  "driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
		driver.get("https://www.cnn.com");
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies(); keep it on the top before declaring website
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // asking the browser to wait
	}
	
	@Test
	public void LoginTest() {
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
		

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}





