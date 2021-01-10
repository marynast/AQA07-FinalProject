package browserService;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.AddProjectField;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import utils.Waiters;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;
    private Waiters waiters;
    private String baseUrl;
    public AddProjectField addProjectField;

    public BrowserService() {
    }

    public void setupBrowser() {

        ReadProperties readProperties = new ReadProperties();
        baseUrl = readProperties.getURL();

        switch (readProperties.getBrowserName().toLowerCase()) {
            case "chrome":
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(new ReadProperties().isHeadless());
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            case "firefox":
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.setHeadless(new ReadProperties().isHeadless());
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("Browser is not supported.");
                break;
        }

        waiters = new Waiters(driver, readProperties.getTimeOut());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Waiters getWaiters() {
        return waiters;
    }

}
