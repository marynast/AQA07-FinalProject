package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectTestCasesPage extends BasePage {

    private By ADD_TEST_CASE = By.xpath("//a[@class='sidebar-button']");

    public ProjectTestCasesPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(By.cssSelector(".content-header-title.page_title"));
    }

    public WebElement getAddTestCasesButton() {
        return waiters.getElementBy(ADD_TEST_CASE);
    }
}
