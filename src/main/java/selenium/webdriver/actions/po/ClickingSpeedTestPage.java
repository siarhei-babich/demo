package selenium.webdriver.actions.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import selenium.webdriver.po.AbstractPage;

public class ClickingSpeedTestPage extends AbstractPage {
	
	public final static String URL = "http://cookie.riimu.net/speed/";
	
	@FindBy(css="#virtualCookie")
	private WebElement virtualCookie;
	
	@FindBy(xpath="//*[@id='realClicksPerSecond']/span[2]")
	private WebElement numberOfClicksPerSprint;

	public ClickingSpeedTestPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isMouseHover() {
		if(virtualCookie.getAttribute("width").equals("256")) {
			System.out.println("Cursor is NOT over the virtual cookie");
			return false;
		} else {
			System.out.println("Cursor is over the virtual cookie");
			return true;
		}
	}
	
	public ClickingSpeedTestPage moveCursorToVirtualCookie() {
		Actions builder = new Actions(driver);
		builder.moveToElement(virtualCookie).build().perform();
		return this;
	}
	
	public ClickingSpeedTestPage doubleClickOnVirtualCookie(int numberOfTimes) {
		Actions builder = new Actions(driver);
		for(int i=0; i<numberOfTimes; i++) {
			builder.moveToElement(virtualCookie).build().perform();
			builder.doubleClick().build().perform();
		}
		return this;
	}
	
	public int getNumberOfClicksInSprint() {
		return Integer.valueOf(numberOfClicksPerSprint.getText());
	}

}