package steps;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.TopicsPage;
import utils.ConfigReader;

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
        homePage.clickTopicsHeaderLink();
    }

    @When("the user enters {string} in the search bar")
    public void typeInTopicsSearchBar(String topic){
        topicsPage.enterTopicSearchField(topic);
    }

    @And("the user clicks the Search button")
    public void userClickTopicsSearchBar(){
        topicsPage.clickTopicSearchButton();
    }

    @Then("the search results should contain {string}")
    public void searchResultIsDisplayed(String expectedResult){
        String actualResult = topicsPage.verifySearchResult();
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Expected search result to contain '" + expectedResult + "' but got: '" + actualResult + "'");
    }

}
