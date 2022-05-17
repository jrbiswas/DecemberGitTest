package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearningXpath {
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
	public void Xpath() {
		
		
	driver.findElement(By.cssSelector("input#username")).sendKeys("demo@techfios.com");
	driver.findElement(By.cssSelector("input#password")).sendKeys("abc123");
	
	//Absolute xpath
	//driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button")).click();
	
	//Relative XPath
	//driver.findElement(By.xpath("//button[@name='login']")).click();
	
	//Relative Path with multiple attributes
	driver.findElement(By.xpath("//button[@name='login'and @type='submit']")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]"))));
	driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]")).click();
	
	
	
	
	
		
	}
	
}
