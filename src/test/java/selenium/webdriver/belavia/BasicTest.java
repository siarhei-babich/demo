package selenium.webdriver.belavia;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import selenium.webdriver.belavia.dto.Offer;
import selenium.webdriver.belavia.po.HomePage;
import selenium.webdriver.belavia.po.RegionalSettingsPage;
import selenium.webdriver.belavia.po.SpecialOffersPage;

public class BasicTest extends AbstractTest {
	
	String locale;
	
	@Factory(dataProvider="locales")
	public BasicTest(String locale) {
		this.locale = locale;
	}
	
	@DataProvider(name = "locales", parallel=true)
	public Object[][] locales() {
		return new Object[][]{
			{ "English" }, { "Deutsch" }, { "Русский" }
		};
	}

	@Test(description = "Special offers test"/*, dataProvider = "locales"*/)
	public void specialOffersTest(/*String locale*/) {
		RegionalSettingsPage rsp = new RegionalSettingsPage(driver);
		HomePage hp = rsp.setRegionalSettings(locale).openHomePage();
		SpecialOffersPage sop = hp.openSpecialOffersPage();
		ArrayList<Offer> offers = sop.getListOfSpecialOffers();
		for (Offer offer : offers) {
			Assert.assertTrue(offer.getDeparture().equals("Minsk") ^ offer.getDestination().equals("Minsk"), String.format("%s has an unexpected route!", offer.toString()));
			Assert.assertTrue(offer.getPrice() < 200, String.format("%s is a too expensive offer!", offer.toString()));
		}
	}
	
}