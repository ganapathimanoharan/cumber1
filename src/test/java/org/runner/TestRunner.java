package org.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\Elanchezhiyan\\eclipse-workspace\\Cumber\\src\\test\\resources\\facebook.feature"}, 
glue= {"org.stepdef"})
public class TestRunner {


}
