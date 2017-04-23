package com.stay.stepdefs;

import static org.junit.Assert.assertTrue;

import com.stay.pageobjects.HomePage;
import com.stay.utilities.Config;
import com.stay.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
	@When("^I run this$")
	public void i_run_this() throws Throwable {
	 Driver.getInstance().get(Config.getProperty("url"));
	}

	@Then("^It should pass$")
	public void it_should_pass() throws Throwable {
	 HomePage homePage = new HomePage();
	 homePage.search.sendKeys("smth");
	 assertTrue(Driver.getInstance().getTitle().contains("Google"));
	 System.out.println("Test");
	}

}
