package com.sw300.acme;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MakeCourseSchedule.feature")
public class FunctionalTest {

    @Test
    public void cucumberTest() {
    }
}
