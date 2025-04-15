package steps;

import base.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginDataModel;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LoginDataReader;

public class LoginSteps{

    private ScenarioContext scenarioContext;
    private LoginPage loginPage;
    private HomePage homePage;
    private LoginDataModel loginDataModel;
    private String baseURL;

    public LoginSteps(ScenarioContext scenarioContext){
        System.out.println("LoginSteps constructor called with ScenarioContext: " + scenarioContext); // Add this
        this.scenarioContext = scenarioContext;
        this.loginDataModel = LoginDataReader.getLoginData();
        this.baseURL = scenarioContext.getBaseURL();
        System.out.println("LoginSteps constructor - baseURL: " + this.baseURL); // Add this
    }

    @Given("the user is on the home page")
    public void userOnHomePage(){
        System.out.println("@Given userOnHomePage() - Getting Driver from ScenarioContext: " + scenarioContext.getDriver()); // Add this
        this.homePage = new HomePage(scenarioContext.getDriver());
        this.loginPage = new LoginPage(scenarioContext.getDriver());
        scenarioContext.getBaseURL();
    }

    @When("the user navigates to the Sign in page")
    public void userNavigateLoginPage(){
        homePage.clickSignInIcon();
    }

    @And("the user logs in with valid data")
    public void userEnterValidData(){
        loginPage.enterEmail(loginDataModel.getEmail());
        loginPage.enterPassword(loginDataModel.getPassword());
    }

    @Then("the user should be redirected to the homepage")
    public void userRedirectedToHomepage(){
        String expectedUrl = baseURL;
        Assert.assertEquals(scenarioContext.getDriver().getCurrentUrl(), expectedUrl, "User was not redirected to the homepage");
    }
}
