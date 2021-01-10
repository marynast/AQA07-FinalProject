package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.AddTestCasePage;



import java.io.File;

public class AddTestCaseStep extends BaseUtil {
    public AddTestCaseStep(BrowserService browserService) {
        super(browserService);
    }

    AddTestCasePage addTestCasePage = new AddTestCasePage(browsersService);

    @Step("Populate the Title of the test case")
    @And("user populates the Title field with the text {string}")
    public void userPopulatesTitleField(String titleText) {
        addTestCasePage.getTitleField().sendKeys(titleText);
    }

    @Step("Populate the steps in the test case")
    @And("user populates the Steps field with the text {string}")
    public void userPopulatesStepsField(String stepsText) {
        addTestCasePage.getStepsField().sendKeys(stepsText);
    }

    @Step("Populate the expected result in the test case")
    @And("user populates the Expected Result field with the text {string}")
    public void userPopulatesExpectedResultField(String expectedResultText) {
        addTestCasePage.getExpectedResultField().sendKeys(expectedResultText);
    }

    @Step("Add an image")
    @And("user adds an image")
    public void userAddsImage() {
        addTestCasePage.dropFile(new File("/Users/marina/IdeaProjects/AQA07-FinalProject/src/images/1.png"), addTestCasePage.expectedResultDropArea(), 0, 0);
        addTestCasePage.dropAreaIsNotVisible();
    }

    @Step("Save test case")
    @And("user clicks Save test case button")
    public void userClicksSaveTestCaseButton() {
        addTestCasePage.getSaveTestCaseButton().submit();

    }
}
