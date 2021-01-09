package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.ProjectTestCasesPage;


public class ProjectTestCasesStep extends BaseUtil {

    ProjectTestCasesPage projectTestCasesPage = new ProjectTestCasesPage(browsersService);

    public ProjectTestCasesStep(BrowserService browserService) {
        super(browserService);
    }

    @Step
    @And("user clicks Add Test Case button")
    public void userClicksAddTestCaseButton() {
        projectTestCasesPage.getAddTestCasesButton().click();
    }
}
