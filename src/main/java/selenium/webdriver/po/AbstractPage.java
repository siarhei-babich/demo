package selenium.webdriver.po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

}