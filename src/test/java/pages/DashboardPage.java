package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends BasePage {

    private static By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    private static By TOOLTIP_BUTTON = By.xpath("//a[@class='link link-tooltip']");
    private static By TOOLTIP_TEXT = By.xpath("//a[@tooltip-text='Change the time frame for the chart.']");
    private static By SELECT_PROJECT = By.xpath("//div[@class='summary-title text-ppp']/a[text()='Test project']");

    public DashboardPage(WebDriver driver) {
        super(driver, false);
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

    public WebElement selectProject() {
        return waiters.getElementBy(SELECT_PROJECT);
    }

    public void clickSelectedProject() {
        WebElement webElement = selectProject();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
        webElement.click();
    }
}