package com.sw300.acme;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        strict = true,
        plugin = {"pretty"},
        features = "src/test/resources/MakeCourseSchedule.feature",
        glue = "package.of.steps")
public class CucumberRunner {

//    @Given("OperationTeamMember")
//    public void operationTeamMember(){
//
//    }
}
