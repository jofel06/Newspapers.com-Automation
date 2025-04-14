package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    private static final Properties properties = new Properties();
    private static final String config_path = "src/test/resources/config.properties";

    static {
        try (FileInputStream inputStream = new FileInputStream(config_path)) {
            properties.load(inputStream);
        }
        catch (IOException e) {
            throw new RuntimeException("Configuration properties not found at " + config_path, e);
        }
    }

    public static String getBaseURL(){
        String baseURL = properties.getProperty("baseURL");
        if (baseURL == null) {
            throw new RuntimeException("baseURL is missing in the configuration properties.");
        }
        return baseURL;
    }



}
