package steps.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.LoginPage;
import support.MyWebDriver;
import browserService.ReadProperties;

public class LoginStep extends BaseStep {

    public LoginStep(MyWebDriver driver) {
        super(driver);
    }

    LoginPage loginPage = new LoginPage(driver);

    @Given("user is logged into TestRail")
    public void userIsLoggedIntoTestRail() {
        loginPage.getLogin().sendKeys(new ReadProperties().getUsername());
        loginPage.getPassword().sendKeys(new ReadProperties().getPassword());
        loginPage.getLogInButton().click();
    }

    @When("user opens login page")
    public void userOpensLoginPage() {
        driver.get(new ReadProperties().getURL());
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
}
