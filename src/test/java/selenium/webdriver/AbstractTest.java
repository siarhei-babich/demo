package selenium.webdriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class AbstractTest {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void startDriver() throws MalformedURLException, UnknownHostException {
//		driver = new FirefoxDriver();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);
		
		driver = new RemoteWebDriver(new URL(String.format("http://%s:4444/wd/hub", InetAddress.getLocalHost().getHostName())), DesiredCapabilities.chrome());
		
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