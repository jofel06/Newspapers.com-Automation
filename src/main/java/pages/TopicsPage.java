package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopicsPage extends BasePage{

    @FindBy(css = "input[type='search']")
    private WebElement topicSearchField;
    @FindBy(css = "input[type='submit']")
    private WebElement topicSearchButton;
    @FindBy(linkText = "RMS Titanic")
    private WebElement rmsTitanicLink;

    public TopicsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterTopicSearchField(String text){
        type(topicSearchField, text);
    }

    public void clickTopicSearchButton(){
        click(topicSearchButton);
    }

    public void clickRMSTitanicLinkPage(){
        click(rmsTitanicLink);
    }

    public String verifySearchResult(){
        return isDisplayed(rmsTitanicLink);
    }
}
