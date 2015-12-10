package selenium.webdriver.jsexecutor.po;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import selenium.webdriver.po.AbstractPage;

public class DragAndDropPage extends AbstractPage {

	public final static String URL = "http://html5demos.com/drag#";

	@FindBy(css = "#bin")
	private WebElement bin;

	@FindBy(css = "#one")
	private WebElement one;

	@FindBy(css = "#two")
	private WebElement two;

	@FindBy(css = "#three")
	private WebElement three;

	@FindBy(css = "#four")
	private WebElement four;

	@FindBy(css = "#five")
	private WebElement five;

	@FindBy(css = "[draggable]")
	private List<WebElement> listOfDraggableWebElements;

	public DragAndDropPage(WebDriver driver) {
		super(driver);
	}

	public DragAndDropPage highlightElements(List<WebElement> listOfElementsElements) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement element : listOfElementsElements) {
			js.executeScript("arguments[0].style.border='5px groove red'", element);
		}

		takeScreenshot(driver);
		return this;
	}
	
	public DragAndDropPage addTwentyText(List<WebElement> listOfElementsElements) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement element : listOfElementsElements) {
			js.executeScript(String.format("arguments[0].textContent='%s'", "twenty"+element.getText()), element);
		}
		
		takeScreenshot(driver);
		return this;
	}
	
	public DragAndDropPage removeDraggableElements(List<WebElement> listOfElementsElements) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement element : listOfElementsElements) {
			js.executeScript("arguments[0].remove()", element);
		}

		takeScreenshot(driver);
		return this;
	}

	public ArrayList<String> getExistingItems() {
		ArrayList<String> listOfExisingItems = new ArrayList<String>();

		return listOfExisingItems;

	}

	public List<WebElement> getListOfDraggableWebElements() {
		return listOfDraggableWebElements;
	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}