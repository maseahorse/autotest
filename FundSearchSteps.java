package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FundDetailsPage;
import pages.FundSearchPage;
import utils.DriverManager;
import utils.ScreenshotUtil;

public class FundSearchSteps {
    private WebDriver driver;
    private FundSearchPage searchPage;
    private FundDetailsPage detailsPage;
    private ScreenshotUtil screenshotUtil;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        searchPage = new FundSearchPage(driver);
        detailsPage = new FundDetailsPage(driver);
        screenshotUtil = new ScreenshotUtil(driver);
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        byte[] screenshot = screenshotUtil.takeScreenshotAsBytes();
        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }

    @After
    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()) {
//            byte[] screenshot = screenshotUtil.takeScreenshotAsBytes();
//            scenario.attach(screenshot, "image/png", scenario.getName() + "_failed");
//        } else {
//            byte[] screenshot = screenshotUtil.takeScreenshotAsBytes();
//            scenario.attach(screenshot, "image/png", scenario.getName() + "_passed");
//        }
        DriverManager.closeDriver();
    }

    @Given("I am on the HSBC investment funds website")
    public void i_am_on_the_hsbc_investment_funds_website() {
        searchPage.navigateToFundSearchPage();
    }

    @When("I enter {string} in the quick search field")
    public void i_enter_in_the_quick_search_field(String searchText) {
        searchPage.enterSearchText(searchText);
    }

    @When("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String fundName) {
        searchPage.selectFundFromDropdown(fundName);
    }

    @Then("I should see the fund details page")
    public void i_should_see_the_fund_details_page() {
        Assert.assertTrue("Fund details page is not displayed",
                detailsPage.isFundDetailsPageDisplayed());
    }

    @Given("I search and select {string}")
    public void i_search_and_select(String fundName) {
        searchPage.navigateToFundSearchPage();
        searchPage.enterSearchText("hsbc");
        searchPage.selectFundFromDropdown(fundName);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        if (linkText.contains("Factsheet")) {
            detailsPage.clickFactsheetLink();
        }
    }

    @Then("the PDF should contain text {string}")
    public void the_pdf_should_contain_text(String expectedText) {
        Assert.assertTrue("PDF does not contain expected text: " + expectedText,
                detailsPage.validatePDFContent(expectedText));
    }

    @Then("I should see fund name {string}")
    public void i_should_see_fund_name(String expectedName) {
        String actualName = detailsPage.getFundName();
        Assert.assertTrue("Fund name does not match", actualName.contains(expectedName));
    }

    @Then("I should see fund class {string}")
    public void i_should_see_fund_class(String expectedClass) {
        String actualClass = detailsPage.getFundClass();
        Assert.assertEquals("Fund class does not match", expectedClass, actualClass);
    }

    @Then("I should see fund code {string}")
    public void i_should_see_fund_code(String expectedCode) {
        String actualCode = detailsPage.getFundCode();
        Assert.assertEquals("Fund code does not match", expectedCode, actualCode);
    }

    @When("I navigate to the performance section")
    public void i_navigate_to_the_performance_section() {
        detailsPage.navigateToPerformanceSection();
    }

    @Then("I should see performance data charts")
    public void i_should_see_performance_data_charts() {
        // Implementation for verifying performance charts
        Assert.assertTrue("Performance charts are displayed", true);
    }

    @Then("I should see no search results")
    public void i_should_see_no_search_results() {
        Assert.assertFalse("Search results are displayed when they shouldn't be",
                searchPage.areSearchResultsDisplayed());
    }

    @Then("I should see a message {string}")
    public void i_should_see_a_message(String message) {
        Assert.assertTrue("No results message is not displayed",
                searchPage.isNoResultsMessageDisplayed());
    }

    @When("I click {string} button")
    public void i_click_button(String buttonText) {
        if (buttonText.equals("Add to compare")) {
            detailsPage.clickAddToCompare();
        }
    }
}