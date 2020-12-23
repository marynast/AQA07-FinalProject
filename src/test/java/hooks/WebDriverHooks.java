package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import support.MyWebDriver;

public class WebDriverHooks {

    private final EventFiringWebDriver driver;

    public WebDriverHooks(MyWebDriver driver) {
        this.driver = driver;
    }
}


