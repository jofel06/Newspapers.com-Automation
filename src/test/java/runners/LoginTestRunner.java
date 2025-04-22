package runners;

import base.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/gherkin_features/login.feature", //this is the path to the Gherkin features directory
        glue = {"steps", "base"}, // Path to the step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true) // Clean console output (no weird symbols or colors).

@Test
public class LoginTestRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browser")
    public void setupBrowser(String browser) {
        Hooks.setBrowser(browser); //Passes the browser parameter to Hooks
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
