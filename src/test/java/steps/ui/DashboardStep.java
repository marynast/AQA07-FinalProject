package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import support.MyWebDriver;

public class DashboardStep extends BaseUtil {

    public DashboardStep(BrowserService browserService) {
        super(browserService);
    }

    @And("Dashboard page is opened")
    public void dashboardPageIsOpened() {
       new DashboardPage(browsersService);
    }

    @When("User clicks Add Project button")
    public void userClicksAddProjectButton() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.getProjectButton().click();
    }

    @When("user clicks on project Test project")
    public void userClicksOnProjectTestProject() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.clickSelectedProject();
    }
}
