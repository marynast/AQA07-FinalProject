package steps.ui;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import pages.LoginPage;
import support.MyWebDriver;
import browserService.ReadProperties;

public class LoginStep extends BaseStep {

    public LoginStep(MyWebDriver webDriver) {
        super(webDriver);
    }

    @Step
    @Given("user is logged into TestRail")
    public void userIsLoggedIntoTestRail() {
        ReadProperties readProperties = new ReadProperties();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLogin().sendKeys(readProperties.getUsername());
        loginPage.getPassword().sendKeys(readProperties.getPassword());
        loginPage.getLogInButton().click();
    }


}
