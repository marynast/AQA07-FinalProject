package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class LoginPage extends BasePage {

    private static By LOGIN_FIELD = By.id("name");
    private static By PASSWORD_FIELD = By.id("password");
    private static By LOG_IN_BUTTON = By.id("button_primary");
    private static By ERROR_TEXT = By.xpath("//div[text() = 'Email/Login or Password is incorrect. Please try again.']");

    public LoginPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL());
    }

    @Override
    public boolean isPageOpened() {
         return waiters.isElementDisplayed(LOG_IN_BUTTON);
    }

    public WebElement getLogin() {
       return waiters.getElementBy(LOGIN_FIELD);
    }

    public WebElement getPassword() {
        return waiters.getElementBy(PASSWORD_FIELD);
    }

    public WebElement getLogInButton() {
        return  waiters.getElementBy(LOG_IN_BUTTON);
    }

    public WebElement getErrorText() {
        return waiters.getElementBy(ERROR_TEXT);
    }

}
