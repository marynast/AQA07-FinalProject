package steps.ui;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.MyWebDriver;
import utils.Waiters;

public class BaseStep {
    public final EventFiringWebDriver driver;
    public Waiters waiters;

    public BaseStep(MyWebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
    }
}
