package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.NoSuchElementException;

public class TopicsPage extends BasePage{

    @FindBy(css = "input[type='search']")
    private WebElement topicSearchField;
    @FindBy(css = "input[type='submit']")
    private WebElement topicSearchButton;
    @FindBy(css = "h2.entry-title > a")
    private List<WebElement> topicSearchResult;
    @FindBy(css = "h1.entry-title > a")
    private List<WebElement> topicArticlePage;

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

    public List<String> getTopicSearchResult(){
        return topicSearchResult.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickTopicSearchResult(String substring) {
        for (WebElement link : topicSearchResult) {
            if (link.getText().contains(substring)) {
                link.click();
                return;
            }
            }
            throw new NoSuchElementException("Could not find a search result containing '" + substring + "'; available results: "
                            + topicSearchResult.stream().map(WebElement::getText).toList());
        }
        
    public List<String> getTopicArticlePage(){
        return topicArticlePage.stream().map(WebElement::getText).collect(Collectors.toList());
        }
}
