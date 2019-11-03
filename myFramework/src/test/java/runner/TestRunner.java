package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = {"Features/CreateUser.feature"},
		 glue = {"stepDefinitions"},
		 plugin = { "pretty", "html:target/site/Cucumber-reports",
		 			"json:target/cucumber.json" },
		 format= {"json:target/CucumberTestReport.json"}
		 ,monochrome = true)
public class TestRunner {
	
	

}
