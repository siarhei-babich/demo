package selenium.webdriver.belavia.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.webdriver.po.AbstractPage;

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