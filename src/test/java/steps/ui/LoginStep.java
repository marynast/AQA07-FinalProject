package steps.ui;

import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import support.MyWebDriver;

public class LoginStep extends BaseStep {
    private WebDriver driver;

    public LoginStep(MyWebDriver driver) {
        super(driver);
    }

    @Step
    @Given("user is logged into TestRail")
    public void userIsLoggedIntoTestRail(String username, String psw) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.getLogin().sendKeys(username);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLogInButton().click();
    }
}
