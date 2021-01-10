package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class BrowserStep extends BaseUtil {

    public BrowserStep(BrowserService browserService) {
        super(browserService);
    }

    @Given("Browser is started")
    public void browserIsStarted() {
        browsersService.setupBrowser();
        browsersService.getDriver().get(properties.getURL());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (browsersService.getDriver() != null) {
            try {
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) browsersService.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Screenshot");
                    saveScreenshot(screenshot);
                }
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots);
            }
            browsersService.getDriver().quit();
            browsersService = null;
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}

