package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ForgotPasswordPage;


public class ForgotPasswordStep extends BaseUtil {
    public ForgotPasswordStep(BrowserService browserService) {
        super(browserService);
    }

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(browsersService);

    @Step("Enter invalid email to reset the password")
    @And("user inputs not existing email {string} to reset password")
    public void userInputsEmailToResetPassword(String emailAddress) {
        forgotPasswordPage.getEmailInput().sendKeys(emailAddress);
    }

    @Step("Click Reset password button")
    @And("user clicks Reset Password button")
    public void userClicksResetPasswordButton() {
        forgotPasswordPage.getPasswordResetConfirmButton().submit();
    }

    @Step("Check the success message")
    @Then("success text {string} is displayed")
    public void successTextIsDisplayed(String successText) {
        Assert.assertTrue(forgotPasswordPage.getSuccessText().isDisplayed());
    }
}
