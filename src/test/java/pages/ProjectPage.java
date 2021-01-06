package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver, false);
    }

    private static By SELECT_TEST_CASES_TAB = By.xpath("//li/a[text()='Test Cases']");

    private static By ACTIONS_SECTION = By.xpath("//div[@class='sidebar-h1 top']");
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(ACTIONS_SECTION);
    }

    public WebElement selectTestCasesTab() {
        return waiters.getElementBy(SELECT_TEST_CASES_TAB);
    }
}
