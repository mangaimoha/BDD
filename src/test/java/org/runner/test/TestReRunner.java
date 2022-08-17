package org.runner.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= "@target\\failedScenario.txt",
									glue="org.definition.step",
									plugin= {"rerun:target\\failedScenario.txt"})
public class TestReRunner {
	
}
