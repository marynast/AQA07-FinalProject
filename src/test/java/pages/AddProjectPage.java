package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class AddProjectPage extends BasePage {

    private String ENDPOINT = "/index.php?/admin/projects/add";
    private By PROJECT_NAME = By.id("name");
    private By ANNOUNCEMENT = By.id("announcement");
    private By ADD_PROJECT = By.id("accept");
    private By RADIO_RECOMMENDED = By.xpath("//div[@class='radio']/label/input[@id='suite_mode_single']");

    public AddProjectPage(BrowserService browserService, boolean openPageByUrl) {
        super(browserService, openPageByUrl);
    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
      return browserService.getWaiters().isElementDisplayed(By.name("name"));
    }

    public WebElement getProjectNameField() {
        return browserService.getWaiters().getElementBy(PROJECT_NAME);
    }

    public WebElement getAnnouncementField() {
        return browserService.getWaiters().getElementBy(ANNOUNCEMENT);
    }

    public boolean getRadioButtonRecommended() {
        return browserService.getWaiters().getElementToBeSelected(RADIO_RECOMMENDED);
    }

    public WebElement getAddProjectButton() {
        return browserService.getWaiters().getElementBy(ADD_PROJECT);
    }
}