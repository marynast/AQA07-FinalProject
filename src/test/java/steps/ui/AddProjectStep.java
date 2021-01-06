package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AddProjectPage;
import pages.ProjectsAdministrationPage;
import support.MyWebDriver;

public class AddProjectStep extends BaseStep {

    AddProjectPage addProjectPage = new AddProjectPage(driver);

    public AddProjectStep(MyWebDriver driver) {
        super(driver);
    }

    @And("project info from db where project id = {int}")
    public void getProjectInfoFromDb ( int id) {


    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String expectedText) {
        Assert.assertEquals(new ProjectsAdministrationPage(driver, false).getProjectAddedMessage(),
                expectedText,
                "Project was NOT added");
    }
}
