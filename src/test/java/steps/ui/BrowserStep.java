package steps.ui;

import dataBaseService.DataBaseService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import support.MyWebDriver;
import browserService.ReadProperties;

import java.sql.SQLException;


public class BrowserStep extends BaseStep {



    public BrowserStep(MyWebDriver driver) {
        super(driver);
    }

    @BeforeTest
    public void setUpConnection(){
        org.apache.log4j.BasicConfigurator.configure();
        dataBaseService = new DataBaseService();
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
        driver.get(new ReadProperties().getURL());
    }

    @AfterTest
    public void closeConnection() throws SQLException {
        dataBaseService.closeConnection();
    }
}

