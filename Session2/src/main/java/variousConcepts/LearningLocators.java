package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningLocators {
	
	WebDriver driver;
	
	
	@Before

	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", " .\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",  "driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies(); keep it on the top before declaring website
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // asking the browser to wait
		
	}

	@Test
	public void LearnDifferentLocators() {
		
		//driver.findElement(By.linkText("Forgot password ?")).click(); // for full link
		//driver.findElement(By.partialLinkText("password")).click(); // for partial link
	
    // CSS Selectors : TagName # Value
		driver.findElement(By.cssSelector("input#username")).sendKeys("demo@techfios.com");
		
	// CSS Selectors : TagName . Value
       //driver.findElement(By.cssSelector("input.form-control")).sendKeys("can't use bacuse we need unique value");	
		
	// CSS Selectors : TagName[attribute]
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		
	// CSS Selectors :[]+ Another attribute can be used to get an unique element by adding another attribute
	 driver.findElement(By.cssSelector("input[class='form-control'][placeholder='Password']")).sendKeys("abc123");
								
		
	}
}
