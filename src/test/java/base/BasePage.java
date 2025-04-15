package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void type(WebElement element, String text){
        element.clear();
        element.sendKeys(text);

    }
}
