package stepDefinitions;

import baseSetup.WebDriverSetup;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.SignInPage;
import utils.ConfigReader;

public class LoginStepDefinitions extends WebDriverSetup {

    private ConfigReader configReader;
    private SignInPage signInPage;
    private HomePage homePage;

    public LoginStepDefinitions(){
        super();
        this.homePage = new HomePage(driver);
        this.signInPage = new SignInPage(driver);
        this.configReader = new ConfigReader();
    }

    @Given("the user is on the home page")
    public void userOnHomePage(){
        String baseURL = configReader.getBaseURL();
            driver.get(baseURL);

    }

}
