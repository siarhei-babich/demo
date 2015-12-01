package selenium.webdriver.examples;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.webdriver.belavia.dto.Offer;

public class BadExampleTest {
	
	@Test
	public void specialOffersTest() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://belavia.by/");
		new Select(driver.findElement(By.cssSelector("#langs_en_default, #langs_uni"))).selectByVisibleText("English");
		driver.findElement(By.cssSelector("input[value='Enter'], input[value='Select']")).click();
		driver.findElement(By.cssSelector("a[href='/news/special_offers/']")).click();
		ArrayList<Offer> offers = new ArrayList<Offer>();
		for(int i=0; i < driver.findElements(By.cssSelector("div.wysiwygContent tr")).size(); i++) {
			String departure = driver.findElements(By.cssSelector("strong")).get(i).getText().split("-")[0];
			String destination = driver.findElements(By.cssSelector("strong")).get(i).getText().split("-")[1];
			int price = Integer.valueOf(driver.findElements(By.cssSelector("h3")).get(i).getText().replaceAll("\\D", ""));
			offers.add(new Offer(departure, destination, price));
		}
		for (Offer offer : offers) {
			Assert.assertTrue(offer.getDeparture().equals("Minsk") || offer.getDestination().equals("Minsk"), String.format("%s has an unexpected route!", offer.toString()));
			Assert.assertTrue(offer.getPrice() < 200, String.format("%s is a too expensive offer!", offer.toString()));
		}
		driver.quit();
	}

}