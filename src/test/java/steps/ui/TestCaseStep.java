package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.TestCasePage;


public class TestCaseStep extends BaseUtil {

    TestCasePage testCasePage = new TestCasePage(browsersService);

    public TestCaseStep(BrowserService browserService) {
        super(browserService);
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
