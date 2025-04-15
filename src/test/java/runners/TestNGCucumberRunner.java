package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/gherkin_features", //this is the path to the Gherkin features directory
        glue = "steps", // Path to the step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true) // Clean console output (no weird symbols or colors).

@Test
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
