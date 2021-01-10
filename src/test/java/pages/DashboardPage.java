package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends BasePage {

    private static By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");
    private static By TOOLTIP_BUTTON = By.xpath("//a[@class='link link-tooltip']");
    private static By TOOLTIP_TEXT = By.xpath("//div[@id='tooltip']/p[text()='Change the time frame for the chart.']");
    private static By SELECT_PROJECT = By.xpath("//div[@class='summary-title text-ppp']/a[text()='Test project']");
    private static By ADMINISTRATION_BUTTON = By.id("navigation-admin");

    public DashboardPage(BrowserService browserService) {
        super(browserService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(ADD_PROJECT_BUTTON);
    }

    public WebElement getProjectButton() {
        return browserService.getWaiters().getElementBy(ADD_PROJECT_BUTTON);
    }

    public WebElement getTooltipButton() {
        return browserService.getWaiters().getElementBy(TOOLTIP_BUTTON);
    }

    public void moveToTooltipButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getTooltipButton()).build().perform();
    }

    public String getTooltipText() {
        moveToTooltipButton();
        return browserService.getWaiters().getElementBy(TOOLTIP_TEXT).getText();
    }

    public WebElement selectProject() {
        return browserService.getWaiters().getElementBy(SELECT_PROJECT);
    }

    public WebElement getAdministrationButton (){
        return browserService.getWaiters().getElementBy(ADMINISTRATION_BUTTON);
    }

    public void clickSelectedProject() {
        WebElement webElement = selectProject();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
        webElement.click();
    }
}