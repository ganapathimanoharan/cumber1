package org.adactin;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\adactinHotel.feature"}, glue= {"org.stepadactin"})
public class Hotel {

}
