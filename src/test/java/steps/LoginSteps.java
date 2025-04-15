package steps;

import base.BaseTest;
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

public class LoginSteps extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private LoginDataModel loginDataModel;
    private String baseURL;

    public LoginSteps(){
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.loginDataModel = LoginDataReader.getLoginData();
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
        loginPage.enterEmail(loginDataModel.getEmail());
        loginPage.enterPassword(loginDataModel.getPassword());
    }

    @Then("the user should be redirected to the homepage")
    public void userRedirectedToHomepage(){
        String expectedUrl = baseURL;
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the homepage");

    }



}
