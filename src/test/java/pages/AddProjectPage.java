package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class AddProjectPage extends BasePage {

    private String ENDPOINT = "/index.php?/admin/projects/add";
    private By PROJECT_NAME = By.xpath("//input[@id='name']");
    private By ANNOUNCEMENT = By.xpath("//textarea[@id='announcement']");
    private By ADD_PROJECT = By.xpath("//button[@id='accept']");
    private By RADIO_RECOMMENDED = By.xpath("//div[@class='radio']/label/input[@id='suite_mode_single']");

    public AddProjectPage(WebDriver driver) {
        super(driver, true);
    }

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(PROJECT_NAME).isDisplayed();
    }

    public WebElement getProjectNameField() {
        return driver.findElement(PROJECT_NAME);
    }

    public WebElement getAnnouncementField() {
        return driver.findElement(ANNOUNCEMENT);
    }

    public boolean getRadioButtonRecommended() {
        return driver.findElement(RADIO_RECOMMENDED).isSelected();
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(ADD_PROJECT);
    }
}