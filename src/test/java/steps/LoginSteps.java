package steps;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginDataModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LoginDataReader;

import java.util.concurrent.ConcurrentHashMap;

public class LoginSteps{

    private LoginPage loginPage;
    private HomePage homePage;
    LoginDataModel loginDataModel = LoginDataReader.getLoginData();

    public LoginSteps(){
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.homePage = new HomePage(Hooks.getDriver());
    }

    @Given("the user is on the home page")
    public void userOnHomePage(){
       Hooks.getDriver().get(ConfigReader.getUrl());
    }

    @When("the user navigates to the Sign in page")
    public void userNavigateLoginPage(){
        homePage.clickSignInIcon();
    }

    @Then("the user logs in with valid data")
    public void userEnterValidData(){
        loginPage.enterEmail(loginDataModel.getEmail());
        loginPage.enterPassword(loginDataModel.getPassword());
    }


}
