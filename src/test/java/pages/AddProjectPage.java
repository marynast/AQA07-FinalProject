package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class AddProjectPage extends BasePage {

    private static By NAME_FIELD = By.id("name");
    private static By ANNOUNCEMENT_FIELD = By.id("announcement");
    private static By SHOW_ANNOUNCEMENT = By.id("show_announcement");
    private static By SINGLE_MODE = By.id("suite_mode_single");
    private static By SINGLE_BASELINE_MODE = By.id("suite_mode_single_baseline");
    private static By MULTIPLE_MODE = By.id("suite_mode_multi");
    private static By ADD_PROJECT_BUTTON = By.id("accept");

    public AddProjectPage(BrowserService browserService ) {
        super(browserService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
      return browserService.getWaiters().isElementDisplayed(By.name("name"));
    }

    public WebElement getNameField(String name){
        return browserService.getWaiters().getElementBy(NAME_FIELD);
    }

    public WebElement getAnnouncementField(String announcement){
        return browserService.getWaiters().getElementBy(ANNOUNCEMENT_FIELD);
    }

    public WebElement getShowAnnouncement (){
        return browserService.getWaiters().getElementBy(SHOW_ANNOUNCEMENT);
    }

    public WebElement getSingleMode (){
        return browserService.getWaiters().getElementBy(SINGLE_MODE);
    }

    public WebElement getSingleBaselineMode (){
        return browserService.getWaiters().getElementBy(SINGLE_BASELINE_MODE);
    }

    public WebElement getMultipleMode (){
        return browserService.getWaiters().getElementBy(MULTIPLE_MODE);
    }

    public WebElement getAddProjectButton (){
        return browserService.getWaiters().getElementBy(ADD_PROJECT_BUTTON);
    }
}