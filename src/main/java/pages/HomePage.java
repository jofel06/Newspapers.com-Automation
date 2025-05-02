package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = "a[class='MemberNavigation_HeaderButtonLink__L6X_g']")
    private WebElement signInIcon;

    private final By topicHeadersLink = By.xpath
            ("//nav[@role='navigation']//a[@href='/topics/']");
    //@FindBy(linkText = "Topics")
    //private WebElement topicHeadersLink;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInIcon(){
        click(signInIcon);
    }

    public void clickTopicsHeaderLink(){
        WebElement topicsLink = waitForLocator(topicHeadersLink);
        topicsLink.click();

    }
}
