package org.runner.test;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.lib.global.JVMReporting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles\\ForgotPassword.feature",
									glue = "org.definition.step", 
									monochrome = true,
									dryRun = false ,
									tags = {"@sanity" }
									//plugin = {
									//		"json:target\\report.json",
									//"rerun:target\\failedScenario.txt" }
									)
public class TestRunner {
	/*@AfterClass
	public static void reportGen() {
		JVMReporting.generateReport("target\\report.json");

	}*/

}
