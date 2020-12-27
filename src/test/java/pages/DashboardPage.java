package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class DashboardPage extends BasePage {

    public String ENDPOINT = "/index.php?/dashboard";
    private static By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    private static By TOOLTIP_BUTTON = By.xpath("//a[class='link link-tooltip']");
    private static By TOOLTIP_TEXT = By.xpath("//a[tooltip-text='Change the time frame for the chart.']");

    public DashboardPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(ADD_PROJECT_BUTTON).isDisplayed();
    }

    public WebElement getProjectButton() {
        return driver.findElement(ADD_PROJECT_BUTTON);
    }

    public WebElement getTooltipButton() {
        return driver.findElement(TOOLTIP_BUTTON);
    }

    public String getTooltipText() {
        return driver.findElement(TOOLTIP_TEXT).getText();
    }
}