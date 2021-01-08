package pages;

import baseEntities.BasePage;
import baseEntities.BaseUtil;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTestCasesPage extends BasePage {

    private By ADD_TEST_CASE = By.xpath("//a[@class='sidebar-button']");

    public ProjectTestCasesPage(BrowserService browserService) {
        super(browserService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(By.cssSelector(".content-header-title.page_title"));
    }

    public WebElement getAddTestCasesButton() {
        return browserService.getWaiters().getElementBy(ADD_TEST_CASE);
    }
}
