package selenium.webdriver.belavia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

	@FindBy(css = "a[href='/news/special_offers/']")
	WebElement allSpecialOffersLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public SpecialOffersPage openSpecialOffersPage() {
		allSpecialOffersLink.click();
		return PageFactory.initElements(driver, SpecialOffersPage.class);
	}

}
