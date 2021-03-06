
package variousConcept;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Selenium_Bank_Cash {

	WebDriver driver;

	@Before
	public void launchBrowser() throws InterruptedException {

		System.out.println("This is before method");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();// delete the cookies
		driver.get("https://techfios.com/billing/?ng=dashboard/"); // using the url for going to the website
		driver.manage().window().maximize(); // maximizing the window
		Thread.sleep(4000);
	}

	@Test
	public void bankCash() throws InterruptedException {

		System.out.println("this is login method");

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com"); // identify USERNAME and data insertion
		driver.findElement(By.id("password")).sendKeys("abc123"); // identify Password and data insertion
		driver.findElement(By.name("login")).click(); // identify Signin element and click
		driver.findElement(By.partialLinkText("Bank & Cash")).click(); // for bank and cash button
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("New Account")).click(); // for new account
		
		Thread.sleep(4000);
		driver.findElement(By.id("account")).sendKeys("checking account");
		driver.findElement(By.id("description")).sendKeys("household expence");
		driver.findElement(By.id("balance")).sendKeys("$5000.00");
		driver.findElement(By.id("account_number")).sendKeys("000-225-3389");
		driver.findElement(By.id("contact_person")).sendKeys("techfios team");
		driver.findElement(By.id("contact_phone")).sendKeys("123-456-7890");
		driver.findElement(By.id("ib_url")).sendKeys("http://www.techfios.com");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class= 'btn btn-primary']")).click();
		Thread.sleep(4000);
}

	@After
	public void tearDown() throws InterruptedException {
		System.out.println(" This is after method");
		driver.close();
		Thread.sleep(4000);
	}

}



