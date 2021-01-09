package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.DashboardPage;


public class GetTooltipStep extends BaseUtil {
    public GetTooltipStep(BrowserService browserService) {
        super(browserService);
    }

    DashboardPage dashboardPage = new DashboardPage(browsersService);

    @When("User hovers the mouse over the text 14 days")
    public void userHoversTheMouseOverTheText() {
        Actions actions = new Actions((WebDriver) browsersService);
        actions.moveToElement(dashboardPage.getTooltipButton()).build().perform();
    }

    @Then("Text {string} is present")
    public void text_is_present(String expectedTooltipText) {
    }
}
