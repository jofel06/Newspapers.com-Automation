package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage{

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "button[title='Sign in with Newspapers.com']")
    private WebElement NewsPapersButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        type(emailField, email);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void signInWithNewspapersButton(){
        click(NewsPapersButton);
    }
}
