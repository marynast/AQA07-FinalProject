package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import support.MyWebDriver;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(MyWebDriver driver) {
        super(driver);
    }

    @Given("Dashboard page is opened")
    public void dashboardPageIsOpened() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPageIsOpened();
    }

    @When("user clicks Add Project button")
    public void userClicksAddProjectButton() {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.getProjectButton().click();
    }

    @When("user selects {string} field and inputs {string}")
    public void userSelectsFieldAndInputs(String string, String string2) {

    }

    @When("user selects the checkbox {string}")
    public void userSelectsTheCheckbox(String string) {

    }

    @When("user selects radio button {int} {string}")
    public void userSelectsRadioButton(Integer int1, String string) {

    }

    @When("user clicks Add Project button in the bottom of the page")
    public void userClicksAddProjectButtonInTheBottom() {

    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String string) {

    }

    @Then("project {string} is displayed in the list of projects")
    public void projectIsDisplayedInTheListOfProjects(String string) {

    }
}
