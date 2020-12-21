package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyWebDriver extends EventFiringWebDriver {

    public MyWebDriver(WebDriver driver) {
        super(driver);
    }

}
