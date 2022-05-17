
package variousConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Assign_1 {

	static WebDriver  driver;
	 
	public static void main(String[] args) throws InterruptedException {
		
		launchBrowser();
		loginTest();
		bankAccount();
		tearDown();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();// delete the cookies
		
	}

	
public static void launchBrowser() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();// delete the cookies
		
		driver.get("https://techfios.com/billing/?ng=admin/"); // using the url for going to the website 
		
		driver.manage().window().maximize(); // maximizing the window
		
		Thread.sleep(4000);
}




public  static void loginTest() throws InterruptedException{
	
	System.out.println("This is test method");
		
	  driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		
	  driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		
      driver.findElement(By.name("login")).click(); // identify Signin element and click
      
      driver.findElement(By.partialLinkText("Bank & Cash")).click(); // for bank and cash button
     
      driver.findElement(By.partialLinkText("New Account")).click(); // for new account
      
      Thread.sleep(4000);
} 

  public static void bankAccount() throws InterruptedException  {
	
	driver.findElement(By.id("account")).sendKeys("checking account");
	
	driver.findElement(By.id("description")).sendKeys("household expence");
	
	driver.findElement(By.id("balance")).sendKeys("$5000.00");
	
	driver.findElement(By.id("account_number")).sendKeys("000-225-3389");
	
	driver.findElement(By.id("contact_person")).sendKeys("techfios team");
	
	driver.findElement(By.id("contact_phone")).sendKeys("123-456-7890");
	
	driver.findElement(By.id("ib_url")).sendKeys("http://www.techfios.com");
	
	Thread.sleep(4000);
	
	//driver.findElement(By.xpath("//button[@class= 'btn btn-primary'l")).click();
	//driver.findElement(By.id("Submit")).submit();
    

	
}
	
  
  public static void tearDown() throws InterruptedException{
		 
	  driver.close(); // closing the browser
   
	  Thread.sleep(4000);    
  }
   
	
	
	
	
	
	
}
