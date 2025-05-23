package utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import models.LoginDataModel;
import java.io.IOException;
import java.io.File;

public class LoginDataReader {
    public static LoginDataModel getLoginData(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File("src/test/resources/test_data/LoginData.json"), LoginDataModel.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to locate the JSON login data", e);
        }
    }


}
