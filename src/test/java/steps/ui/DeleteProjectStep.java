package steps.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import support.MyWebDriver;

public class DeleteProjectStep extends BaseStep {
    public DeleteProjectStep(MyWebDriver webDriver) {
        super(webDriver);
    }
    @Given("{string} is created")
    public void projectIsCreated(String string) {

    }

    @Given("Administration Projects page is opened")
    public void administrationProjectsPageIsOpened() {

    }

    @When("user clicks {string} on the right from the project name")
    public void userClicksOnTheRightFromTheProjectName(String string) {

    }

    @When("and selects the checkbox {string}")
    public void and_selects_the_checkbox(String string) {

    }

    @When("and clicks {string} button")
    public void and_clicks_button(String string) {

    }

}
