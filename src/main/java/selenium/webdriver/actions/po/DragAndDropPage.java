package selenium.webdriver.actions.po;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import selenium.webdriver.po.AbstractPage;

public class DragAndDropPage extends AbstractPage {

	@FindBy(id="bin")
	private WebElement bin;
	
	@FindBy(id="one")
	private WebElement one;
	
	@FindBy(id="two")
	private WebElement two;
	
	@FindBy(id="three")
	private WebElement three;
	
	@FindBy(id="four")
	private WebElement four;
	
	@FindBy(id="five")
	private WebElement five;
	
	@FindBy(css="[draggable]")
	private List<WebElement> listOfDraggableWebElements;
	
	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}
	
	@SuppressWarnings("deprecation")
	public DragAndDropPage dragAndDropItemToBin(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='5px groove red'", two, three);
		js.executeScript("document.getElementById('five').remove()");
		js.executeScript("document.getElementById('four').textContent='ten';");
		Actions builder = new Actions(driver);
		builder.clickAndHold(one).pause(1000).moveToElement(bin).pause(1000).release().build().perform();
		return this;
	}
	
	public ArrayList<String> getExistingItems() {
		ArrayList<String> listOfExisingItems = new ArrayList<String>();
		
		return listOfExisingItems; 
		
	}
	
	public List<WebElement> getListOfDraggableWebElements() {
		return listOfDraggableWebElements;
	}

}