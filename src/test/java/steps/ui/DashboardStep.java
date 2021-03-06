package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.DashboardPage;

public class DashboardStep extends BaseUtil {

    public DashboardStep(BrowserService browserService) {
        super(browserService);
    }

    @Step("Open Dashboard page")
    @And("Dashboard page is opened")
    public void dashboardPageIsOpened() {
       new DashboardPage(browsersService);
    }
    @Step("Click Add project button")
    @When("User clicks Add Project button")
    public void userClicksAddProjectButton() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.getProjectButton().click();
    }

    @Step("Select Test project")
    @When("user clicks on project Test project")
    public void userClicksOnProjectTestProject() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.clickSelectedProject();
    }
}
