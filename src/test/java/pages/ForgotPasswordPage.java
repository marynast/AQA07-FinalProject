package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends BasePage {

    private By EMAIL_INPUT = By.id("name");
    private By RESET_PASSWORD_CONFIRM_BUTTON = By.xpath("//button[@class='forgot_passwordpage-request " +
            "forgot_passwordpage-request-focus forgot_passwordpage-request-active forgot_passwordpage-request-hover ']");
    private By SUCCESS_TEXT = By.xpath("//div[text() = 'Email sent successfully. Please check your email inbox for the " +
            "reset password instructions.']");

    public ForgotPasswordPage(BrowserService browserService) {
        super(browserService, false);
    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(By.id("name"));
    }

    public WebElement getEmailInput() {
        return browserService.getWaiters().getElementBy(EMAIL_INPUT);
    }

    public WebElement getPasswordResetConfirmButton() {
        return browserService.getWaiters().getElementBy(RESET_PASSWORD_CONFIRM_BUTTON);
    }

    public WebElement getSuccessText() {
        return browserService.getWaiters().getElementBy(SUCCESS_TEXT);
    }
}
