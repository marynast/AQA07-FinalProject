package steps.ui;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.ProjectPage;
import support.MyWebDriver;

public class ProjectPageStep extends BaseStep {
    public ProjectPageStep(MyWebDriver driver) {
        super(driver);
    }

    ProjectPage projectPage = new ProjectPage(driver);

    @Step
    @And("user selects TEST CASES TAB")
    public void userSelectsTestCasesTab() {
        projectPage.selectTestCasesTab().click();
    }
}
