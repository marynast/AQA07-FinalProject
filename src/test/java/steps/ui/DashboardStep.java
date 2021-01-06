package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import support.MyWebDriver;

public class DashboardStep extends BaseStep {

    DashboardPage dashboardPage = new DashboardPage(driver);

    public DashboardStep(MyWebDriver driver) {
        super(driver);
    }

    @And("Dashboard page is opened")
    public void dashboardPageIsOpened() {
       new DashboardPage(driver);
    }

    @When("user clicks Add Project button")
    public void userClicksAddProjectButton() {
        dashboardPage.getProjectButton().click();
    }

    @When("user clicks on project Test project")
    public void userClicksOnProjectTestProject() {
        dashboardPage.clickSelectedProject();
    }
}
