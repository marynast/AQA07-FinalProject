package steps;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.MyWebDriver;

public class BaseStep {

    public final EventFiringWebDriver driver;
    WebDriverWait wait;

    public BaseStep(MyWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
}
