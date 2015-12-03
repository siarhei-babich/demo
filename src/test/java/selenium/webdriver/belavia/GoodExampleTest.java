package selenium.webdriver.belavia;

import java.util.ArrayList;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import selenium.webdriver.belavia.dto.Offer;
import selenium.webdriver.belavia.po.HomePage;
import selenium.webdriver.belavia.po.RegionalSettingsPage;
import selenium.webdriver.belavia.po.SpecialOffersPage;

public class GoodExampleTest extends AbstractTest {
	
	String locale;
	
	@Factory(dataProvider="locales")
	public GoodExampleTest(String locale) {
		this.locale = locale;
	}
	
	@DataProvider(name = "locales", parallel=true)
	public Object[][] locales() {
		return new Object[][]{
			{ "English" }, { "Deutsch" }, { "Русский" }
		};
	}
	
	@BeforeMethod(description = "WebDriver initialization")
	public void prepare() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(RegionalSettingsPage.BELAVIA_URL);
	}

	@Test(description = "Special offers test")
	public void specialOffersTest() {
		RegionalSettingsPage rsp = new RegionalSettingsPage(driver);
		HomePage hp = rsp.setRegionalSettings(locale).openHomePage();
		SpecialOffersPage sop = hp.openSpecialOffersPage();
		ArrayList<Offer> offers = sop.getListOfSpecialOffers();
		for (Offer offer : offers) {
			Assert.assertTrue(offer.getDeparture().equals("Minsk") ^ offer.getDestination().equals("Minsk"), String.format("%s has an unexpected route!", offer.toString()));
			Assert.assertTrue(offer.getPrice() < 200, String.format("%s is a too expensive offer!", offer.toString()));
		}
	}
	
	@AfterMethod(description = "WebDriver claen up")
	public void cleanUp() {
		driver.quit();				
	}
	
}