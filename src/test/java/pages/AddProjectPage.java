package pages;

import baseEntities.BasePage;
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

    public AddProjectPage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
      return waiters.isElementDisplayed(By.name("name"));
    }

    public WebElement getProjectNameField() {
        return waiters.getElementBy(PROJECT_NAME);
    }

    public WebElement getAnnouncementField() {
        return waiters.getElementBy(ANNOUNCEMENT);
    }

    public boolean getRadioButtonRecommended() {
        return waiters.getElementToBeSelected(RADIO_RECOMMENDED);
    }

    public WebElement getAddProjectButton() {
        return waiters.getElementBy(ADD_PROJECT);
    }
}