package selenium.webdriver.actions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.webdriver.AbstractTest;
import selenium.webdriver.actions.po.DragAndDropPage;

public class DragAndDropTest extends AbstractTest {
	
	public final static String URL = "http://html5demos.com/drag#";
	
	List<WebElement> listOfDraggableWebElements;
	
	@Test
	public void dragAndDropItemsToBin() {
		driver.get(URL);
		DragAndDropPage ddp = new DragAndDropPage(driver);
		List<WebElement> listOfDraggableWebElements;
		listOfDraggableWebElements  = ddp.getListOfDraggableWebElements();
		printNumberOfExisitngDraggableElements(listOfDraggableWebElements);
		ddp.dragAndDropItemToBin(listOfDraggableWebElements.get(0));
		listOfDraggableWebElements  = ddp.getListOfDraggableWebElements();
		printNumberOfExisitngDraggableElements(listOfDraggableWebElements);
	}
	
	private void printNumberOfExisitngDraggableElements(List<WebElement> listOfDraggableWebElements) {
		System.out.println(String.format("Draggable elements found: %d", listOfDraggableWebElements.size()));
	}

}
