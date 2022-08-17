package org.definition.step;

import org.junit.AfterClass;
import org.lib.global.JVMReporting;
import org.lib.global.LibGlobalClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends LibGlobalClass{

	@Before
	public void beforeScenario() {
		System.out.println("Before Scenario");		
		openChrome();
		launchUrl("https://adactinhotelapp.com/");	
		maxWindow();
			
	}	
	
	@After(order=2)
	public void aft(Scenario s) {
		TakesScreenshot ts= (TakesScreenshot)driver;
		byte[] screens = ts.getScreenshotAs(OutputType.BYTES);
		s.embed(screens, "image/png");
	}
	@After(order=1)
	public void afterScenario() {
		System.out.println("After Scenario");
		closeBrowser();
	}
	
	
	
}
	
	