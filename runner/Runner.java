package Cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Cucumber/features",
        glue =  "Cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)

public class Runner {}