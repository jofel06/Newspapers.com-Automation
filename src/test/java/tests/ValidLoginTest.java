package tests;


import base.BaseTest;
import models.LoginData;
import org.testng.annotations.Test;
import utils.LoginDataReader;

public class ValidLoginTest extends BaseTest {

    @Test
    public void testLoginUsingValidData(){
        LoginData login = LoginDataReader.getLoginData();

        login.getEmail();
        login.getPassword();

    }


}
