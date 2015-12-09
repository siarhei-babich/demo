package selenium.webdriver.actions;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.webdriver.AbstractTest;
import selenium.webdriver.actions.po.ClickingSpeedTestPage;
import selenium.webdriver.jqueryui.po.DroppablePage;

public class ActionsTest extends AbstractTest {
	
	@Test
	public void moveToElement() {
		ClickingSpeedTestPage cstp = (ClickingSpeedTestPage) new ClickingSpeedTestPage(driver).open(ClickingSpeedTestPage.URL);
		cstp.isMouseHover();
		cstp.moveCursorToVirtualCookie();
		Assert.assertTrue(cstp.isMouseHover(), "Unable to hover the cursor on the cookie!");
	}
	
	@Test
	public void doubleClick() throws InterruptedException {
		ClickingSpeedTestPage cstp = (ClickingSpeedTestPage) new ClickingSpeedTestPage(driver).open(ClickingSpeedTestPage.URL);
		int numberOfTimes=500;
		cstp.doubleClickOnVirtualCookie(numberOfTimes);
		Assert.assertEquals(cstp.getNumberOfClicksInSprint(), numberOfTimes*2, String.format("Unexpected number of clicks in the sprint! [Actual: %d. Expected: %d.]", cstp.getNumberOfClicksInSprint(), numberOfTimes*2));
	}
	
	@Test()
	public void dragAndDrop() {
		DroppablePage dp = new DroppablePage(driver).open();
		dp.isDropped();
		dp.dragAndDrop();
		Assert.assertTrue(dp.isDropped(), "Unsuccessful to drag and drop!");
	}

}