package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destination = "screenshots/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(screenshotFile, new File(destination));
            System.out.println("Screenshot saved: " + destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
