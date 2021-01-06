package steps.ui;

import browserService.ReadProperties;
import dataBaseService.DataBaseService;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.MyWebDriver;
import utils.Waiters;

public class BaseStep {
    public final EventFiringWebDriver driver;
    public Waiters waiters;
    public ReadProperties properties;
    public DataBaseService dataBaseService;


    public BaseStep(MyWebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
        properties = new ReadProperties();
        dataBaseService = new DataBaseService();

    }
}