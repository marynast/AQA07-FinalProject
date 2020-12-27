package baseEntities;

import browserService.ReadProperties;
import dataBaseService.DataBaseService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class BaseUtil {
    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();
    public DataBaseService dataBaseService;

    public BaseUtil() {
    }
}
