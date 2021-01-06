package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.AddTestCasePage;
import pages.DashboardPage;
import pages.TestCasePage;
import support.MyWebDriver;

public class AddTestCaseWithFileUploadStep extends BaseStep {
    public AddTestCaseWithFileUploadStep(MyWebDriver driver) {
        super(driver);
    }

    DashboardPage dashboardPage = new DashboardPage(driver);
    AddTestCasePage addTestCasePage = new AddTestCasePage(driver);
    TestCasePage testCasePage = new TestCasePage(driver);

    @Step
    @When("user clicks on project Test project")
    public void userClicksOnProjectTestProject() {
        dashboardPage.selectProject().click();
    }

    @Step
    @And("user selects TEST CASES TAB")
    public void userSelectsTestCasesTab() {
        dashboardPage.selectTestCasesTab().click();
    }

    @Step
    @And("user clicks Add Test Case button")
    public void userClicksAddTestCaseButton() {
        addTestCasePage.getAddTestCasesButton().click();
    }

    @Step
    @And("user populates the Title field with the text {string}")
    public void userPopulatesTitleField(String titleText) {
        addTestCasePage.getTitleField().sendKeys(titleText);
    }

    @Step
    @And("user populates the Steps field with the text {string}")
    public void userPopulatesStepsField(String stepsText) {
        addTestCasePage.getStepsField().sendKeys(stepsText);
    }

    @Step
    @And("user populates the Expected Result field with the text {string}")
    public void userPopulatesExpectedResultField(String expectedResultText) {
        addTestCasePage.getExpectedResultField().sendKeys(expectedResultText);
    }

    @Step
    @And("user adds an image")
    public void userAddsImage() {
        addTestCasePage.uploadFile();
    }

    @Step
    @And("user clicks Save test case button")
    public void userClicksSaveTestCaseButton() {
        addTestCasePage.getSaveTestCaseButton().submit();

    }

    @Step
    @Then("test case is saved and text {string} is present")
    public void testCaseIsSavedAndTextIsPresent(String testCaseSavedText) {
        Assert.assertTrue(testCasePage.TestCaseSavedTextIsDisplayed());
    }

    @Step
    @Then("attachment is displayed")
    public void attachmentIsDisplayed() {
        Assert.assertTrue(testCasePage.attachmentIsDisplayed());
    }
}
