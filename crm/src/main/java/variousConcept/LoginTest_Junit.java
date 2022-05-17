package variousConcept;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {
	
	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println(" Before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}
	

	@Before
public  void launchBrowser(){
		
		System.out.println("This is before method");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();// delete the cookies
		
		driver.get("https://techfios.com/billing/?ng=dashboard/"); // using the url for going to the website 
		
		driver.manage().window().maximize(); // maximizing the window
		
	}
	

@Test
  public  void loginTest(){
	
	System.out.println("This is test method");
		
	  driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		
	  driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		
      driver.findElement(By.name("login")).click(); // identify Signin element and click
		
	}
  
  
  public  void negLoginTest(){
	  System.out.println("Negatibe test method");
		
	  driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		
	  driver.findElement(By.id("password")).sendKeys("abc123456"); // identify Password and data insertion
		
      driver.findElement(By.name("login")).click(); // identify Signin element and click
		
	}
  
  
   @After
  public  void tearDown(){
	   System.out.println("After Method");
		 
	  driver.close(); // closing the browser
   }

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

