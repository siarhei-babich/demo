package selenium.webdriver.jsexecutor;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.webdriver.AbstractTest;
import selenium.webdriver.actions.po.DragAndDropPage;
import selenium.webdriver.jqueryui.po.DroppablePage;

public class JSExecutorTest extends AbstractTest {
	
	List<WebElement> listOfDraggableWebElements;
	
	@Test()
	public void jsExecutor() throws AWTException, InterruptedException {
		DragAndDropPage ddp = (DragAndDropPage) new DragAndDropPage(driver).open(DragAndDropPage.URL);
		List<WebElement> listOfDraggableWebElements;
		listOfDraggableWebElements  = ddp.getListOfDraggableWebElements();
		printNumberOfExisitngDraggableElements(listOfDraggableWebElements);
		ddp.highlightElements(listOfDraggableWebElements);
		ddp.addTwentyText(listOfDraggableWebElements);
		ddp.removeDraggableElements(listOfDraggableWebElements);
		listOfDraggableWebElements  = ddp.getListOfDraggableWebElements();
		printNumberOfExisitngDraggableElements(listOfDraggableWebElements);
	}
	
	private void printNumberOfExisitngDraggableElements(List<WebElement> listOfDraggableWebElements) {
		System.out.println(String.format("Draggable elements found: %d", listOfDraggableWebElements.size()));
	}

}