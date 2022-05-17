package variousConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
	
	static WebDriver driver;
	

	public static void main(String[] args) {
		// call all the methods here in a sequence
		// this is for positive test
			launchBrowser();
			loginTest();
			tearDown();
		
		// this is for negative test
				launchBrowser();
				negLoginTest();
				tearDown();
				
		
		
	}
	
	public static void launchBrowser(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();// delete the cookies
		
		driver.get("https://techfios.com/billing/?ng=admin/"); // using the url for going to the website 
		
		driver.manage().window().maximize(); // maximizing the window
		
	}
	
  public static void loginTest(){
		
	  driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		
	  driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		
      driver.findElement(By.name("login")).click(); // identify Signin element and click
		
	}
  
  
  public static void negLoginTest(){
		
	  driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		
	  driver.findElement(By.id("password")).sendKeys("abc123456"); // identify Password and data insertion
		
      driver.findElement(By.name("login")).click(); // identify Signin element and click
		
	}
  
  
  
  public static void tearDown(){
		 
	  driver.close(); // closing the browser
   }

}
