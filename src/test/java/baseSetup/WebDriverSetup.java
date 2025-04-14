package baseSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.ConfigReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class WebDriverSetup {
    private ConfigReader configReader;
    protected WebDriver driver;

    public WebDriverSetup(){
        configReader = new ConfigReader();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        String baseURL = configReader.getBaseURL(); //This will read the URL path from the config.properties

        driver = initializeDriver(browser);
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private WebDriver initializeDriver(String browser){
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        else {
            throw new IllegalArgumentException("Error! Unsupported Browser" + browser);
        }
        return driver;
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
