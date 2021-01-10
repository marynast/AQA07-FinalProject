package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.DashboardPage;
import pages.ProjectsAdministrationPage;


public class DeleteProjectStep extends BaseUtil {

    public DeleteProjectStep(BrowserService browserService) {
        super(browserService);
    }

    @Step("Select already existing project")
    @And("Select an already-existing project")
    public void selectAnAlreadyExistingProject (){
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.getAdministrationButton().click();
    }

    @Step("Click delete button")
    @When("User clicks delete button on the right from the project name")
    public void userClicksDeleteButtonOnTheRightFromTheProjectName() {
        ProjectsAdministrationPage projectsAdministrationPage = new ProjectsAdministrationPage(browsersService);
        projectsAdministrationPage.getAllProjectsButton().click();
        projectsAdministrationPage.getDeleteProjectButton().click();
    }

    @Step("Select the checkbox")
    @And("Selects the checkbox")
    public void selectTheCheckbox (){
        ProjectsAdministrationPage projectsAdministrationPage = new ProjectsAdministrationPage(browsersService);
        projectsAdministrationPage.getConfirmDeleteCheckbox().click();
    }

    @Step("Click OK button")
    @And("Clicks OK button")
    public void clicksOkButton (){
        ProjectsAdministrationPage projectsAdministrationPage = new ProjectsAdministrationPage(browsersService);
        projectsAdministrationPage.getConfirmDeleteButton().click();
    }

    @Step("Check that the project was deleted")
    @Then("Project successfully deleted")
    public void projectSuccessfullyDeleted() {
        Assert.assertEquals(new ProjectsAdministrationPage(browsersService).getProjectDeletedMessage(),
                "Successfully deleted the project.",
                "Project was NOT deleted.");
    }
}
