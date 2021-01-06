package steps.ui;

import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.TestCasePage;
import support.MyWebDriver;

public class TestCaseStep extends BaseStep {
    public TestCaseStep(MyWebDriver driver) {
        super(driver);
    }
    TestCasePage testCasePage = new TestCasePage(driver);

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
