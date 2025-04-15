package base;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class ScenarioContext {
    private WebDriver driver;
    private String baseURL;

    public ScenarioContext() {
        this.baseURL = ConfigReader.getBaseURL();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getBaseURL() {
        return baseURL;
    }
}
