package com.epam.cucumber.compare.qa.acceptance.tests.cucumber4.w3schools;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "html:target/cucumber-html-report"},
        features = {"src/test/resources"},
        tags = {"@debug"}
)
public class RunAcceptanceDebugIT {

}