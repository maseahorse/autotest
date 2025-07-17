package utils;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private WebDriver driver;
    private static final String SCREENSHOT_DIR = "test-output/screenshots/";

    public ScreenshotUtil(WebDriver driver) {
        this.driver = driver;
    }

//    private void createScreenshotDirectory() {
//        File directory = new File(SCREENSHOT_DIR);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//    }

    public byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

//    public void takeScreenshot(String scenarioName) {
//        try {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
//
//            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
//            File destFile = new File(SCREENSHOT_DIR + fileName);
//
//            FileUtils.copyFile(sourceFile, destFile);
//
//            // Attach screenshot to ExtentReports
//            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(destFile.getAbsolutePath());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}