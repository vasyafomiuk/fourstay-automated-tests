package com.stay.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/com/stay/features",
		glue="com/stay/stepdefs"
// dryRun
// tags
)

public class CukesRunner {

}
