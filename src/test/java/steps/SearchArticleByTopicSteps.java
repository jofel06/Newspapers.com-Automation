package steps;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.TopicsPage;
import utils.AssertionUtils;
import utils.ConfigReader;
import utils.ScreenshotUtils;

import java.util.List;

public class SearchArticleByTopicSteps {
    private HomePage homePage;
    private TopicsPage topicsPage;

    public SearchArticleByTopicSteps(){
        this.topicsPage = new TopicsPage(Hooks.getDriver());
        this.homePage = new HomePage(Hooks.getDriver());
    }

    @Given("the user is on the Newspapers.com homepage")
    public void userOnHomePage(){
        Hooks.getDriver().get(ConfigReader.getUrl());
    }

    @And("the user clicks the \"Topics\" header link")
    public void clickTopicsHeaderLink(){
        ScreenshotUtils.takeScreenshot(Hooks.getDriver(), "before_click_search_button");
        homePage.clickTopicsHeaderLink();
    }

    @When("the user enters {string} in the search bar")
    public void typeInTopicsSearchBar(String topic){
        topicsPage.enterTopicSearchField(topic);
    }

    @And("the user clicks the Search button")
    public void clickTopicsSearchBar(){
        topicsPage.clickTopicSearchButton();
    }

    @Then("the search results should contain {string}")
    public void searchResultIsDisplayed(String expectedResult){
        List<String> results = topicsPage.getTopicSearchResult();
        AssertionUtils.assertListContainsSubstring(results, expectedResult);
    }

    @When("the user clicks on {string} from the results")
    public void clickSearchResult(String result){
        topicsPage.clickTopicSearchResult(result);
    }

    @Then("the article details page for {string} should be displayed")
    public void verifyArticleDetailsPageIsDisplayed(String expectedResult){
        List<String> results = topicsPage.getTopicArticlePage();
        AssertionUtils.assertListContainsSubstring(results, expectedResult);
    }
}
