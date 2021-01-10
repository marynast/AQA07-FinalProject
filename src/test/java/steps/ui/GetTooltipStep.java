package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.DashboardPage;


public class GetTooltipStep extends BaseUtil {
    public GetTooltipStep(BrowserService browserService) {
        super(browserService);
    }

    DashboardPage dashboardPage = new DashboardPage(browsersService);

    @When("User hovers the mouse over the text 14 days")
    public void userHoversTheMouseOverTheText() {
        dashboardPage.moveToTooltipButton();
    }

    @Then("Text {string} is present")
    public void text_is_present(String expectedTooltipText) {
        Assert.assertEquals(dashboardPage.getTooltipText(), expectedTooltipText);
    }
}
