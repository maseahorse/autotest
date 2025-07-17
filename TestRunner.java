package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.junit.AfterClass;
import utils.DriverManager;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml"
        },
        monochrome = true,
        publish = true
)

public class TestRunner {
    @AfterClass
    public static void modifyExtentReport() {
        try {
            String reportPath = "test-output/SparkReport/Spark.html";
            String jsFilePath = "src/test/resources/custom-javascript.html";
            String content = new String(Files.readAllBytes(Paths.get(reportPath)), StandardCharsets.UTF_8);
            String jsScript = new String(Files.readAllBytes(Paths.get(jsFilePath)), StandardCharsets.UTF_8);

            // Inject the custom JavaScript before the closing body tag
            content = content.replace("</body>", jsScript + "</body>");

            // replace string
            content = content.replace("Features", "Test Suites");
            content = content.replace("features", "test suites");
            content = content.replace("scenarios", "test cases");
            content = content.replace("steps", "test steps");

            // Write the modified content back to the report file
            Files.write(Paths.get(reportPath), content.getBytes(StandardCharsets.UTF_8));

            System.out.println("Extent Report modified successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}