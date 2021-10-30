package com.trycloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/trycloud/step_definition",
        publish = false,
        dryRun = false,
        plugin = {"pretty", "html:target/cucumber_report1.html"
                , "rerun:target/rerun.txt", "me.jvt.cucumber.report.PrettyReports:target"
        } //tags = "@ui"
        //@wip

)
public class TestRunner {
//Empty class

}
