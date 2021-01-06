package steps.ui;

import io.cucumber.java.en.And;
import io.qameta.allure.Step;
import pages.ProjectTestCasesPage;
import support.MyWebDriver;

public class ProjectTestCasesStep extends BaseStep {
    public ProjectTestCasesStep(MyWebDriver driver) {
        super(driver);
    }

    ProjectTestCasesPage projectTestCasesPage = new ProjectTestCasesPage(driver);

    @Step
    @And("user clicks Add Test Case button")
    public void userClicksAddTestCaseButton() {
        projectTestCasesPage.getAddTestCasesButton().click();
    }
}
