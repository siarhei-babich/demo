package selenium.webdriver.examples;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selenium.webdriver.examples.po.ObjectMap;

import org.openqa.selenium.WebElement;

public class ObjectMapLoginTest {
	public WebDriver driver;
	public ObjectMap objmap;

	@BeforeTest
	public void setUp() throws Exception {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		driver.get("http://www.seleniummaster.com/");
		Thread.sleep(3000);
	}

	@Test
	public void login() throws Exception {

		// Get current working directory
		String workingDir = System.getProperty("user.dir");
		// Get object map file
		objmap = new ObjectMap(workingDir + "\\objectpropertiesfiles\\objectmap.properties");
		// Get the username element
		WebElement username = driver.findElement(objmap.getLocator("Username_field"));
		username.sendKeys("test");
		// Get the password element
		WebElement password = driver.findElement(objmap.getLocator("Password_field"));
		password.sendKeys("XXXXXX");// password is omitted
		// Click on the login button
		WebElement login = driver.findElement(objmap.getLocator("Login_button"));
		login.click();
		Thread.sleep(3000);
		// Assert the user login by checking the Online user
		WebElement onlineuser = driver.findElement(objmap.getLocator("online_user"));
		assertEquals("Online users", onlineuser.getText());

	}

	@AfterTest
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}

}