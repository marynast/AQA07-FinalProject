package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.DashboardPage;

public class GetTooltipStep extends BaseUtil {
    public GetTooltipStep(BrowserService browserService) {
        super(browserService);
    }

    DashboardPage dashboardPage = new DashboardPage(browsersService);

    @Step("Hover the mouse over the text 14 days")
    @When("User hovers the mouse over the text 14 days")
    public void userHoversTheMouseOverTheText() {
        dashboardPage.moveToTooltipButton();
    }

    @Step("Check the expected text is present")
    @Then("Text {string} is present")
    public void text_is_present(String expectedTooltipText) {
        Assert.assertEquals(dashboardPage.getTooltipText(), expectedTooltipText);
    }
}
