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

    @Given("login page is opened")
    public void loginPageIsOpened() {
        driver.get(new ReadProperties().getURL());
    }

    @Step
    @When("user inputs email {string}")
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
