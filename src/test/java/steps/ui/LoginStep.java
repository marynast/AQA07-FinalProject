package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;
import browserService.ReadProperties;

public class LoginStep extends BaseUtil {

    LoginPage loginPage = new LoginPage(browsersService);

    public LoginStep(BrowserService browserService) {
        super(browserService);
    }

    @Given("User is logged into TestRail")
    public void userIsLoggedIntoTestRail() {
        loginPage.getLogin().sendKeys(new ReadProperties().getUsername());
        loginPage.getPassword().sendKeys(new ReadProperties().getPassword());
        loginPage.getLogInButton().click();
    }

    @When("user opens login page")
    public void userOpensLoginPage() {
        browsersService.getDriver().get(properties.getURL());
    }

    @Step
    @And("user inputs email {string}")
    public void userInputsEmail(String validEmail) {
        loginPage.getLogin().sendKeys(validEmail);
    }

    @Step
    @And("invalid password {string}")
    public void invalidPassword(String invalidPassword) {
        loginPage.getPassword().sendKeys(invalidPassword);
    }

    @Step
    @And("clicks login button")
    public void clicksLoginButton() {
        loginPage.getLogInButton().click();
    }

    @Step
    @Then("error text {string} is displayed")
    public void errorTextIsDisplayed(String errorText) {
        Assert.assertTrue(loginPage.getErrorText().isDisplayed());
    }

    @When("user clicks Forgot your password? button")
    public void userClicksForgotYourPasswordButton() {
        loginPage.getForgotPasswordButton().click();
    }
}
