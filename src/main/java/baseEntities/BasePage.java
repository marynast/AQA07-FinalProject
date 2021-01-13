package baseEntities;

import browserService.BrowserService;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 5;
    public final WebDriver driver;
    protected final BrowserService browserService;

    protected abstract void openPage();
    public abstract boolean isPageOpened();


    public BasePage(BrowserService browserService, boolean openPageByUrl) {
        this.browserService = browserService;
        this.driver = browserService.getDriver();

        if (openPageByUrl) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOAD_IN_SECONDS){
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator){
            throw new AssertionError("Page was not opened");
        }
    }
}

