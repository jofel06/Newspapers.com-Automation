package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import utils.ConfigReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        driver = initializeDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(ConfigReader.getBaseURL("baseUrl"));
    }

    private WebDriver initializeDriver(String browser){
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
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
