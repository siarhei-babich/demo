package selenium.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void startDriver() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void stopDriver() {
		driver.quit();				
	}

}