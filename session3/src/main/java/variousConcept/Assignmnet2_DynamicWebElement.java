package variousConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignmnet2_DynamicWebElement {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Owner\\DecemberQA2021_Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // before going to the website, I need to have this delete cookies
		driver.get("https://techfios.com/billing/?ng=dashboard");
		driver.manage().window().maximize(); // maximize the window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Implicit wait we define at the begining of
																		// the code and it will apply to every single
																		// element our driver tries to indentify
	}

	@Test

	public void logInTest() throws InterruptedException {

		// Storing WebElement Library using By Class

		By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
		By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
		By COMPANY_DROPDOWN_FIELD = By.xpath("//*[@id=\"cid\"]");

		// For paasing the value in Class-Fiels we need to assign through
		// driver.findElement

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();

		// To validate the DashBoard page, declare the varible
		By DASH_BOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

		// Assert.assertTrue("Wrong page",
		// driver.findElement(DASH_BOARD_HEADER_FIELD).isDisplayed());
		Assert.assertEquals("Dashboard page not found", "Dashboard",
				driver.findElement(DASH_BOARD_HEADER_FIELD).getText());
		System.out.println(driver.findElement(DASH_BOARD_HEADER_FIELD).getText());

		// GO to Customer and click on it
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Thread.sleep(4000);

		// Selenium works with dropdown with the Class call Select and define as
		// sel(industry standard)

		Select sel = new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
		sel.selectByVisibleText("Techfios");
		Thread.sleep(4000);

// getting all the list of option in the drop down with the getOptions() method for Company

		List<WebElement> op = sel.getOptions();
		int size = op.size();
		for (int i = 0; i <size; i++) {

			WebDriver option;
			String options = op.get(i).getText();
			System.out.println(options);
		

			}
			
		}

	@After

	public void tearDown() {

		driver.close();
		driver.quit();
	}

}
