package steps.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import support.MyWebDriver;
import browserService.ReadProperties;


public class BrowserStep extends BaseStep {
    public BrowserStep(MyWebDriver driver) {
        super(driver);
    }

    @Before
    public void init() {
        org.apache.log4j.BasicConfigurator.configure();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("browser is started")
    public void browserIsStarted() {
        driver.get("");
    }

}

