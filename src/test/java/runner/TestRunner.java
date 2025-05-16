package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features",
        glue = {"stepdefinitions"},
        //tags = "@RegressionTest",
        plugin = {
                /*"pretty", // Pretty console output
                "html:target/cucumber-reports.html", // Cucumber HTML report
                "json:target/cucumber-reports.json", // Cucumber JSON report
                "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/ // ExtentReports plugin
                "pretty", "html:target/cucumber-reports.html" //"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        },
        monochrome = true // Display output in readable format
)
public class TestRunner
{
}
