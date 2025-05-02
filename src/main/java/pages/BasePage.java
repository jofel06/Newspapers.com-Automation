package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForLocator(By Locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
    }

    protected void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void type(WebElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String isDisplayed(WebElement element){
        waitForElement(element);
        return element.getText();
    }
}
