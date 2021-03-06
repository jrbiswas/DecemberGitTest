package variousConcept;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_2_WebElement {
	
	WebDriver driver;
	
	

	 @Before
		public void init() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
			driver.get("https://www.techfios.com/billing/?ng=admin/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); // asking the browser to wait
		}
		
		@Test
		public void loginTest() {
			
			// how do we store web element
			// declare variable by Datatype and value for WebElement
			// Create ELEMENT LIST 
			
			//Storing Data with WebElement
			WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"username\"]")); //when we define the variablel by WebElement, we need to keep Elememnt at the end
			WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));
			//WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
			
			/*USER_NAME_ELEMENT.clear(); // will clear any previous data on the field
			USER_NAME_ELEMENT.sendKeys("demo@techfios.com"); // passing value with web element
			PASSWORD_ELEMENT.sendKeys("abc123");
			SIGNIN_BUTTON_ELEMENT.click();*/
			
			//Storing Data with By CLASS
			By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]"); // when we define the variablel by Class, we need to keep field at the end
			By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
			By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
			By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
			
			
			//  For paasing the value in Class-Fields we need to assign driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
			
			driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		    driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		    driver.findElement(SIGNIN_BUTTON_FIELD).click();
		   
		    
		 /*   Boolean pageTitleDispaly;
		    try {
		    	 WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		    	   boolean pageTitleDisplay = true;
		    }
		       catch( Exception e) {
		    	
		    	   boolean pageTitleDisplay = false;
		    	e.printStackTrace();
		    	
		    } */
		    
		    WebDriverWait wait = new  WebDriverWait(driver, 5);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD));
			
			// To verify whether or not, webpage is landing properly, selenium use Assrertion 
			
		   // Assert.assertTrue( DASHBOARD_HEADER_ELEMENT.isDisplayed()); when we pass the test
		   
		    WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		    Assert.assertTrue("Wrong page!", DASHBOARD_HEADER_ELEMENT.isDisplayed());
		    
		    
			}

		@After
		
		public void tearDown () {
			
			driver.close();
			driver.quit();
		}
		
		
		
	 }






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


