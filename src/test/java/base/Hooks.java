package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private final ScenarioContext scenarioContext;

    public Hooks(ScenarioContext scenarioContext) {
        System.out.println("Hooks constructor called with ScenarioContext: " + scenarioContext); // Add this
        this.scenarioContext = scenarioContext;
    }

    @Before
    public void setUpDriver() {
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver = null; // Initialize driver here

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Error! Unsupported Browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        scenarioContext.setDriver(driver);
        System.out.println("@Before setUpDriver() - Driver set in ScenarioContext: " + scenarioContext.getDriver()); // Add this
    }

    @After
    public void tearDownDriver() {
        WebDriver driver = scenarioContext.getDriver();
        System.out.println("@After tearDownDriver() - Getting Driver from ScenarioContext: " + driver); // Add this
        if (driver != null) {
            driver.quit();
        }
    }
}
