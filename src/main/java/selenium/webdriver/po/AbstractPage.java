package selenium.webdriver.po;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
	
	protected String PAGE_TITLE;
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public boolean isElementWithIDPresent(String id) {
		try	{
			driver.findElement(By.id(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void executeJS(String script) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(script);
	}
	
	public AbstractPage open(String url) {
		driver.get(url);
		return this;
	}
	
	public void takeScreenshot(WebDriver driver) {
		
		File screenshotDir = new File("./test-output/screenshots");

		if (!screenshotDir.exists()) {
		    System.out.println("Creating directory: " + screenshotDir);
		    boolean result = false;

		    try {
		    	screenshotDir.mkdir();
		        result = true;
		    } 
		    catch (SecurityException se){
		    }        
		    if(result) {    
		        System.out.println("Screenshots directory was successfully created");  
		    }
		}
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy-h-mm-ss-a");
		String formattedDate = sdf.format(date);

		String fileName = "screenshot-" + formattedDate;
		try {
			FileUtils.copyFile(scrFile, new File(String.format("./test-output/screenshots/%s.png", fileName)));
			System.out.println(String.format("%s.png was successfully taken", fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AbstractPage open() {
		return this;
	}

}