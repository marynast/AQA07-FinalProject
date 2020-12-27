package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.ProjectsPage;
import support.MyWebDriver;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(MyWebDriver driver) {
        super(driver);
    }
    DashboardPage dashboardPage = new DashboardPage(driver, true);
    AddProjectPage addProjectPage = new AddProjectPage(driver, true);

    @Given("Dashboard page is opened")
    public void dashboardPageIsOpened() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPageIsOpened();
    }

    @When("user clicks Add Project button")
    public void userClicksAddProjectButton() {
        dashboardPage.getProjectButton().click();
    }

    @When("user selects Name field and inputs {string}")
    public void userSelectsNameFieldAndInputs(String projectName) {
        addProjectPage.getProjectNameField().sendKeys(projectName);
    }

    @When("user selects Announcement field and inputs {string}")
    public void userSelectsAnnouncementFieldAndInputs(String announcementText) {
        addProjectPage.getAnnouncementField().sendKeys(announcementText);
    }

    @When("user selects radio button {int}")
    public void userSelectsRadioButton(int radioButton) {
        addProjectPage.getRadioButtonRecommended();
    }

    @When("user clicks Add Project button in the bottom of the page")
    public void userClicksAddProjectButtonInTheBottom() {
        addProjectPage.getAddProjectButton().submit();

    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String expectedText) {
        Assert.assertEquals(new ProjectsPage(driver, false).getProjectAddedMessage(),
                expectedText,
                "Project was NOT added");
    }
}