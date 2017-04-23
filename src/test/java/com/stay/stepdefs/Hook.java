package com.stay.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.stay.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hook {
	public void setUp() {
		Driver.getInstance().manage().window().maximize();
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teardown() {
		Driver.closeDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		// Driver.closeDriver();
	}
}
