package variousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Window_Handle {
	
	WebDriver driver;

@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
		// driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // asking the browser to wait

	}

@Test
	
		public void windowHandle() throws InterruptedException {

			String title1 = driver.getTitle();
			System.out.println(title1);
			String handle1 = driver.getWindowHandle();// keep the window handle in a String variable handle1
			System.out.println(handle1);

			driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
			driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
			Thread.sleep(3000);
			/*String title2 = driver.getTitle();
			  System.out.println(title2);
			  String handle2 = driver.getWindowHandle();
			  System.out.println(handle2);*/

			// w3school
			driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
			Set<String> handles = driver.getWindowHandles(); // this is for set of Strings using Windowhandles
			for (String str: handles) {
				System.out.println(str);
				driver.switchTo().window(str);
			}


			String title3 = driver.getTitle();
			System.out.println(title3);
			
			driver.switchTo().window(handle1);// method of going back to the first window

 }
  @After 
   public void tearDown() {
	  
	  driver.close();
	  driver.quit();
	  
  }
  
	

}
