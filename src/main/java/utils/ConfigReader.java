package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static Properties properties;

    static {
        try (InputStream input = new FileInputStream("src/test/resources/config/config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL(String key){
        return properties.getProperty(key);
    }



}
