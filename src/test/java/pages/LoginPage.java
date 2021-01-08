package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class LoginPage extends BasePage {

    private static By LOGIN_FIELD = By.id("name");
    private static By PASSWORD_FIELD = By.id("password");
    private static By LOG_IN_BUTTON = By.id("button_primary");
    private static By FORGOT_PASSWORD_BUTTON = By.className("loginpage-forgotpassword");
    private static By ERROR_TEXT = By.xpath("//div[text() = 'Email/Login or Password is incorrect. Please try again.']");

    public LoginPage(BrowserService browserService) {
        super(browserService, true);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
         return browserService.getWaiters().isElementDisplayed(LOG_IN_BUTTON);
    }

    public WebElement getLogin() {
       return browserService.getWaiters().getElementBy(LOGIN_FIELD);
    }

    public WebElement getPassword() {
        return browserService.getWaiters().getElementBy(PASSWORD_FIELD);
    }

    public WebElement getLogInButton() {
        return  browserService.getWaiters().getElementBy(LOG_IN_BUTTON);
    }

    public WebElement getErrorText() {
        return browserService.getWaiters().getElementBy(ERROR_TEXT);
    }

    public WebElement getForgotPasswordButton() {
        return browserService.getWaiters().getElementBy(FORGOT_PASSWORD_BUTTON);
    }

}
