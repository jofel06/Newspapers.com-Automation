package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;

public class Hooks {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String browserName;

    public static void setBrowser(String browser) {
        browserName = browser; }

    @Before
    public void setUpDriver(Scenario scenario) {
        if (browserName == null || browserName.isEmpty()) {
            browserName = ConfigReader.getBrowser(); // Default to Chrome if not specified
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                /*ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--no-sandbox");*/
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "edge":
                /*EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
                edgeOptions.addArguments("--disable-gpu");
                edgeOptions.addArguments("--window-size=1920,1080");
                edgeOptions.addArguments("--disable-dev-shm-usage");
                edgeOptions.addArguments("--no-sandbox");*/
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.getUrl());
        System.out.println("Starting scenario: " + scenario.getName() + "on browser: " + browserName);
    }

    @After
    public void quitWebDriver(Scenario scenario) {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
        System.out.println("Ending scenario: " + scenario.getName());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
