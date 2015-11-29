package selenium.webdriver.belavia.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
	
	protected String PAGE_TITLE;
	
	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver ) {
		this.driver = driver;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}

}