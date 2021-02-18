package com.massmutual.Cucumber.TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = { "@regression" }, 
		features = { "src/test/java/com/massmutual/Cucumber/features"}, 
		glue = { "com.massmutual", "com.massmutual.Cucmber.TestRunner" },
		dryRun=false
		)

public class Runner {

}



