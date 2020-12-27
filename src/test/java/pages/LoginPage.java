package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadProperties;

public class LoginPage extends BasePage {

    private static By LOGIN_FIELD = By.id("name");
    private static By PASSWORD_FIELD = By.id("password");
    private static By LOG_IN_BUTTON = By.id("button_primary");

    public LoginPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL());
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(LOGIN_FIELD).isDisplayed();
    }

    public WebElement getLogin() {
       return driver.findElement(LOGIN_FIELD);
    }

    public WebElement getPassword() {
        return driver.findElement(PASSWORD_FIELD);
    }

    public WebElement getLogInButton() {
        return  driver.findElement(LOG_IN_BUTTON);
    }

}
