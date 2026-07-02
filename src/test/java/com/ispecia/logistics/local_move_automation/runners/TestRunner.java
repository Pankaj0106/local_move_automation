package com.ispecia.logistics.local_move_automation.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Test.feature", glue = "com.ispecia.logistics.local_move_automation", plugin = {
		"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json" }, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}


