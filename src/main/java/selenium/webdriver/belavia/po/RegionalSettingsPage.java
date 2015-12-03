package selenium.webdriver.belavia.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegionalSettingsPage extends AbstractPage {

	public static final String BELAVIA_URL = "http://belavia.by/";
	
	@FindBy(css="#langs_en_default, #langs_uni")
	private WebElement languageDropDown;
	
	@FindBy(css="input[value='Enter'], input[value='Select']")
	private WebElement enterButton;

	public RegionalSettingsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public RegionalSettingsPage setRegionalSettings(String language) {
		new Select(languageDropDown).selectByVisibleText(language);
		return this;
	}
	
	public HomePage openHomePage() {
		enterButton.click();
		return PageFactory.initElements(getWebDriver(), HomePage.class);
	}

}