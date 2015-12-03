package selenium.webdriver.belavia.po;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import selenium.webdriver.belavia.dto.Offer;

public class SpecialOffersPage extends AbstractPage {
	
	@FindBy(css="h1")
	private WebElement title;
	
	@FindBy(css="div.wysiwygContent tr")
	private List<WebElement> listOfOfferes;
	
	@FindBys({ @FindBy(css="strong") })
	private List<WebElement> listOfOfferedRoutes;
	
	@FindBys({ @FindBy(css="h3") })
	private List<WebElement> listOfOfferedPrices;
	
	public SpecialOffersPage(WebDriver driver) {
		super(driver);
	}
	
	public ArrayList<Offer> getListOfSpecialOffers() {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		for(int i=0; i < listOfOfferes.size(); i++) {
			String departure = listOfOfferedRoutes.get(i).getText().split("-")[0];
			String destination = listOfOfferedRoutes.get(i).getText().split("-")[1];
			int price = Integer.valueOf(listOfOfferedPrices.get(i).getText().replaceAll("\\D", ""));
			offers.add(new Offer(departure, destination, price));
		}	
		return offers;
	}
	
}