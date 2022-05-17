package variousConcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	String browser = "chrome"; // usually I need to write null; but I am habving only one browser, not the firefox, So keep "chrome"

	// WebElement List
	By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASH_BOARD_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

	// Test Data
	String username = "demo@techfios.com";
	String password = "abc123";

	@BeforeClass
	//Reading the file
	public void readConfig() {
		
		//there are three ways we can read a file: 1) FileReader, 2) InputStream, 3)BufferReader
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			prop.getProperty("browser");
			String browser = prop.getProperty("browser");
			System.out.println("Browser used: " + browser);
			
		}
		catch(IOException e) {
			e.getStackTrace();
		}
		
		
	}
	@BeforeMethod
	public void init() {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		 * driver = new ChromeDriver();
		 */

		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 2)
	public void loginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys(username);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		Assert.assertEquals(driver.findElement(DASH_BOARD_FIELD).getText(), "Dashboard", "Wrong page!");
	}

	@Test(priority = 1)
	public void negLoginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys(username);
		driver.findElement(PASSWORD_FIELD).sendKeys(password);
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		// Assert.assertEquals(driver.findElement(DASH_BOARD_FIELD).getText(),
		// "Dashboard", "Wrong page!");

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();

	}

}
