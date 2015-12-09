package selenium.webdriver.jqueryui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import selenium.webdriver.po.AbstractPage;

public class DroppablePage extends AbstractPage {

	public static final String URL = "http://jqueryui.com/droppable/";
	
	@FindBy(id="draggable")
	private WebElement draggable;
	
	@FindBy(id="droppable")
	private WebElement droppable;
	
	@FindBy(className="demo-frame")
	private WebElement demoFrame;
	
	@FindBy(css="#droppable>p")
	private WebElement droppableText;
	
	public DroppablePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	public DroppablePage open() {
		driver.get(URL);
		return this;		
	}
	
	public boolean isDropped() {
		switchToDemoFrame();
		if (droppableText.getText().equals("Dropped!")) {
			System.out.println("Draggable was already dropped to droppable");
			return true;
		} else {
			System.out.println("Draggable was NOT dropped to droppable");
			return false;
		}
	}
	
	private DroppablePage switchToDemoFrame() {
		if(!isElementWithIDPresent("draggable") && !isElementWithIDPresent("droppable")) {
			driver.switchTo().frame(demoFrame);
			System.out.println("Switched to the demo frame");
		} else {
			System.out.println("You are already in the demo frame");
		}
		return this;
	}
	
	public DroppablePage dragAndDrop() {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(draggable, droppable).build().perform();
//		builder.dragAndDropBy(draggable, 100, 100).build().perform();
		return this;
	}
	
	

}