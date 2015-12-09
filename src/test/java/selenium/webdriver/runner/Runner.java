package selenium.webdriver.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {
	
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();				
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Belavia Suite");
		 
		XmlTest test = new XmlTest(suite);
		test.setName("Good Example Test");
		
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("selenium.webdriver.belavia.GoodExampleTest"));
		test.setXmlClasses(classes) ;
		
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		TestNG testng = new TestNG();
		testng.setXmlSuites(suites);
		testng.addListener(tla);
		testng.run();
	}

}