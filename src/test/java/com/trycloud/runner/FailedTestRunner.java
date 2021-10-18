package com.trycloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class FailedTestRunner {
    @RunWith(Cucumber.class)
//Uses cucumber engine to run the codes

    @CucumberOptions(
            //"classpath:features"
            //src/test/resources/features
            glue = "com/trycloud/step_definitions",
            features = "@target/rerun.txt",
            tags = "@ui"


    )
    public class TestRunner {
//Empty class

    }
}
