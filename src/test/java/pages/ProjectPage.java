package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    private static By SELECT_TEST_CASES_TAB = By.xpath("//li/a[text()='Test Cases']");
    private static By ACTIONS_SECTION = By.xpath("//div[@class='sidebar-h1 top']");




    public ProjectPage(BrowserService browserService) {
        super(browserService,false);
    }


    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(ACTIONS_SECTION);
    }

    public WebElement selectTestCasesTab() {
        return browserService.getWaiters().getElementBy(SELECT_TEST_CASES_TAB);
    }


}
