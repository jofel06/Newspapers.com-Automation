package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static Properties properties = new Properties();
    private static final String configFilePath = "config/config.properties";

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(configFilePath)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Error: Could not find" + configFilePath + "on the classpath.");
                throw new RuntimeException("Configuration file not found: " + configFilePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file: " + configFilePath, e);
        }
    }

    private ConfigReader() { // Private constructor to prevent instantiation
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getBrowser() {
        // This will check for a system property first (in case entered from a command line)
        String browser = System.getProperty("browser");
        if (browser != null && !browser.isEmpty()) {
            return browser;
        }
        //if not, it will default to chrome
        return getProperty("browser", "chrome");
    }

    public static String getUrl() {
        return getProperty("baseURL");
    }
}
