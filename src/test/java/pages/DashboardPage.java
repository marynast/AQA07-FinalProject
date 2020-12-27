package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadProperties;

public class DashboardPage extends BasePage {

    public String ENDPOINT = "/index.php?/dashboard";
    private static By ADD_PROJECT_BUTTON = By.id("sidebar-projects-add");

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
}