package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginData;
import org.testng.Assert;
import pages.HomePage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.LoginDataReader;

public class LoginStep extends BaseTest {

    private SignInPage signInPage;
    private HomePage homePage;
    private LoginData loginData;
    private String baseURL;

    public LoginStep(){
        super();
        this.homePage = new HomePage(driver);
        this.signInPage = new SignInPage(driver);
        this.loginData = LoginDataReader.getLoginData();
        this.baseURL = ConfigReader.getBaseURL("baseURL");
    }

    @Given("the user is on the home page")
    public void userOnHomePage(){
        driver.get(baseURL);
    }

    @When("the user navigates to the Sign in page")
    public void userNavigateLoginPage(){
        homePage.clickSignInIcon();
    }

    @And("the user logs in with valid data")
    public void userEnterValidData(){
        signInPage.enterEmail(loginData.getEmail());
        signInPage.enterPassword(loginData.getPassword());
    }

    @Then("the user should be redirected to the homepage")
    public void userRedirectedToHomepage(){
        String expectedUrl = baseURL;
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the homepage");

    }



}
