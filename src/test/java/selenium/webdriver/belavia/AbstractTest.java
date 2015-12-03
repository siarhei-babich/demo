package selenium.webdriver.belavia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import selenium.webdriver.belavia.po.RegionalSettingsPage;

public class AbstractTest {
	
	WebDriver driver;
	
	@BeforeMethod(description = "WebDriver initialization")
	public void prepare() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(RegionalSettingsPage.BELAVIA_URL);
	}
	
	@AfterMethod(description = "WebDriver claen up")
	public void cleanUp() {
		driver.quit();				
	}

}