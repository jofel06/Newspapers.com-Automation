package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Error: Could not find config/config.properties on the classpath.");
                // 'properties' will remain empty
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseURL() {
        return properties.getProperty("baseURL");
    }
}
