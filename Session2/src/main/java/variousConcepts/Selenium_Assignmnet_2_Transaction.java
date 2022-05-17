package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Assignmnet_2_Transaction {
	
	WebDriver driver;

	@Before
	public void launchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
		driver.get("https://techfios.com/billing/?ng=dashboard");
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test

	public void transaction() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");//
		driver.findElement(By.id("password")).sendKeys("abc123"); //
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
		
		// now I am assigning the value in the New Account input box
		
		 // CSS Selectors : TagName # Value
		//driver.findElement(By.cssSelector("input#username")).sendKeys("demo@techfios.com");
		driver.findElement(By.cssSelector("label#account")).click();
		
	// CSS Selectors : TagName . Value
       //driver.findElement(By.cssSelector("input.form-control")).sendKeys("can't use bacuse we need unique value");	
		
	// CSS Selectors : TagName[attribute]
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		
	// CSS Selectors :[]+ Another attribute can be used to get an unique element by adding another attribute
	 //driver.findElement(By.cssSelector("input[class='form-control'][placeholder='Password']")).sendKeys("abc123");
								
		Thread.sleep(4000);
	}
	
	
	@After
	public void teardown() {
		
		driver.close();
		driver.quit();
	}

}



