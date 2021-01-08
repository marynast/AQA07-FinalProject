package steps.ui;

import baseEntities.BaseUtil;
import browserService.BrowserService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;


public class BrowserStep extends BaseUtil {

    public BrowserStep(BrowserService browserService) {
        super(browserService);
    }

    @Before
    public void init() {
        org.apache.log4j.BasicConfigurator.configure();

    }

    @Given("Browser is started")
    public void browserIsStarted() {
        browsersService.setupBrowser();
        browsersService.getDriver().get(properties.getURL());
    }

    @After
    public void tearDown() {
        browsersService.getDriver().quit();
    }
}

