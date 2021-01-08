package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.ProjectPage;
import support.MyWebDriver;

public class ProjectPageStep extends BaseUtil {

    ProjectPage projectPage = new ProjectPage(browsersService);

    public ProjectPageStep(BrowserService browserService) {
        super(browserService);
    }

    @Step
    @And("user selects TEST CASES TAB")
    public void userSelectsTestCasesTab() {
        projectPage.selectTestCasesTab().click();
    }
}
