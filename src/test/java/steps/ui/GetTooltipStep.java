package steps.ui;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.DashboardPage;
import support.MyWebDriver;

public class GetTooltipStep extends BaseStep {
    public GetTooltipStep(MyWebDriver driver) {
        super(driver);
    }

    DashboardPage dashboardPage = new DashboardPage(driver);

    @When("user hovers the mouse over the text 14 days")
    public void userHoversTheMouseOverTheText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(dashboardPage.getTooltipButton()).build().perform();
    }

    @Then("text {string} is present")
    public void text_is_present(String expectedTooltipText) {
        WebElement element = waiters.getElementBy(By.xpath("//a[@tooltip-text='Change the time frame for the chart.']"));
        String titleText = element.getAttribute("title");
        System.out.println(titleText);
    }
}
