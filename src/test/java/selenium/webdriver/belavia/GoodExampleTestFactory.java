package selenium.webdriver.belavia;

import org.testng.annotations.Factory;

public class GoodExampleTestFactory {
	
	@Factory()
    public Object[] factoryMethod() {
        return new Object[] { new GoodExampleTest("English"), new GoodExampleTest("Deutsch"), new GoodExampleTest("Русский") };
    }

}