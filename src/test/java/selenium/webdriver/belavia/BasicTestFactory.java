package selenium.webdriver.belavia;

import org.testng.annotations.Factory;

public class BasicTestFactory {
	
	@Factory()
    public Object[] factoryMethod() {
        return new Object[] { new BasicTest("English"), new BasicTest("Deutsch"), new BasicTest("Русский") };
    }

}