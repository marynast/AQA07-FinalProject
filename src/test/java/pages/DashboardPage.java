package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class DashboardPage extends BasePage {

    private static By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    private static By TOOLTIP_BUTTON = By.xpath("//a[@class='link link-tooltip']");
    private static By TOOLTIP_TEXT = By.xpath("//a[@tooltip-text='Change the time frame for the chart.']");

    public DashboardPage(WebDriver driver) {
        super(driver,false );
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(ADD_PROJECT_BUTTON);
    }

    public WebElement getProjectButton() {
        return waiters.getElementBy(ADD_PROJECT_BUTTON);
    }

    public WebElement getTooltipButton() {
        return waiters.getElementBy(TOOLTIP_BUTTON);
    }

    public String getTooltipText() {
        return waiters.getElementBy(TOOLTIP_TEXT).getText();
    }
}