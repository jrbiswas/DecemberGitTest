package variousConcept;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {

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

		System.out.println(driver.getTitle()); // getting the tiltle of the yahoo page
		/*String handle1 = driver.getWindowHandle();// keep the window handle in a String variable handle1
		System.out.println(handle1);*/

		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		Thread.sleep(3000);
		/*System.out.println(driver.getTitle()); // search button
		String handle2 = driver.getWindowHandle();
		System.out.println(handle2);*/

		// w3school
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		Set<String> handles = driver.getWindowHandles(); // this is for set of Strings using Windowhandles
		for (String i : handles) {
			System.out.println(i);
			driver.switchTo().window(i);
		}

		// System.out.println(handles); // printing together, but for printing
		// individually, we use for each loop, whicg is above

		System.out.println(driver.getTitle());

	//String handle3 = driver.getWindowHandle(); System.out.println(handle3);
	// for transfering the driver from one tab to other tab, we will use for-loop
    // method

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();

	}

}
