package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ReadProperties;

public class ProjectsPage extends BasePage {

    private String ENDPOINT = "index.php?/admin/projects/overview";

    public ProjectsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    private By DELETE_BUTTON =
            By.xpath("//tr/td/a[text()='Project by Marina']/../following-sibling::*/following-sibling::*/a" +
                    "/div[@class='icon-small-delete']");

    private By CHECKBOX_TO_CONFIRM_DELETE = By.xpath("//span[@class='dialog-confirm-busy']/following::*");

    private By OK_DELETE_PROJECT_BUTTON = By.xpath("//div[@id='deleteDialog']/div" +
            "[@class='button-group dialog-buttons-highlighted']" +
            "/a[@class='button button-ok button-left button-positive dialog-action-default']");

    private By PROJECT_ADDED_MESSAGE = By.xpath("//div[text()='Successfully added the new project.']");

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(By.xpath("//a[text()='Projects']")).isDisplayed();
    }

    public WebElement getDeleteProjectButton() {
        return driver.findElement(DELETE_BUTTON);
    }

    public WebElement getConfirmDeleteCheckbox() {
        return driver.findElement(CHECKBOX_TO_CONFIRM_DELETE);
    }

    public WebElement getConfirmDeleteButton() {
        return driver.findElement(OK_DELETE_PROJECT_BUTTON);
    }

    public String getProjectAddedMessage() {
        return driver.findElement(PROJECT_ADDED_MESSAGE).getText();
    }
}
