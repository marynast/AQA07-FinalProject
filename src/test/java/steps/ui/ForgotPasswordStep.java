package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.ForgotPasswordPage;
import support.MyWebDriver;

public class ForgotPasswordStep extends BaseStep {
    public ForgotPasswordStep(MyWebDriver driver) {
        super(driver);
    }

    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @And("user inputs not existing email {string} to reset password")
    public void userInputsEmailToResetPassword(String emailAddress) {
        forgotPasswordPage.getEmailInput().sendKeys(emailAddress);
    }

    @And("user clicks Reset Password button")
    public void userClicksResetPasswordButton() {
        forgotPasswordPage.getPasswordResetConfirmButton().submit();
    }


    @Then("success text {string} is displayed")
    public void successTextIsDisplayed(String successText) {
        Assert.assertTrue(forgotPasswordPage.getSuccessText().isDisplayed());
    }
}
