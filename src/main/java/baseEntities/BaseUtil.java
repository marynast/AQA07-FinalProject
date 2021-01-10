package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import dataBaseService.DataBaseService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;
import utils.Listener;
import utils.SQLqueries;

import javax.xml.crypto.Data;

@Listeners(Listener.class)
public abstract class BaseUtil {
    public static Logger logger = Logger.getLogger(DataBaseService.class);
    public BrowserService browsersService;
    public ReadProperties properties;
    public DataBaseService dataBaseService;
    public SQLqueries sqLqueries;

    public BaseUtil(BrowserService browserService) {
        this.browsersService = browserService;
        properties = new ReadProperties();
        dataBaseService = new DataBaseService();
        sqLqueries = new SQLqueries();
    }
}
