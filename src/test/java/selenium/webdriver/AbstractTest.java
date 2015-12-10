package selenium.webdriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
	
	protected WebDriver driver;
	
	// TODO
	// specify USERNAME & ACCESS_KEY to run in Sauce Labs
	private final static String USERNAME ="";
	private final static String ACCESS_KEY ="";
	
	@BeforeClass
	public void startDriver() throws MalformedURLException, UnknownHostException {

		driver = new FirefoxDriver();
		
		// RemoteWebDriver block (uncomment to run in a self-configured grid, provide a correct server name)		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setJavascriptEnabled(true);
//		driver = new RemoteWebDriver(new URL(String.format("http://%s:4444/wd/hub", InetAddress.getLocalHost().getHostName())), DesiredCapabilities.chrome());
		
		
		// Sauce Labs block (uncomment to launch in Sauce Labs)
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//      capabilities.setCapability(CapabilityType.PLATFORM, "windows");
//      capabilities.setCapability("name", "RemoteWebDriver Test");
//		driver = new RemoteWebDriver(new URL("http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub"), capabilities);
				
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void start() {
		System.out.println(String.format("-----Start of test-----"));
		
	}
	
	@AfterMethod
	public void finish() {
		System.out.println(String.format("-----End of test-----"));
	}	
	
	@AfterClass
	public void stopDriver() {
		driver.quit();				
	}

}