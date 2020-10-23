package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features//Login.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json",
                "junit:target/rerun.txt"
        }
)
public class TestRunner {
}
