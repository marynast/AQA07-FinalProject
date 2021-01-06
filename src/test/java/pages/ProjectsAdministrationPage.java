package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class ProjectsAdministrationPage extends BasePage {

    private String ENDPOINT = "index.php?/admin/projects/overview";

    public ProjectsAdministrationPage(WebDriver driver, boolean b) {
        super(driver, true);
    }

    private By DELETE_BUTTON =
            By.xpath("//tr/td/a[text()='Project by Marina']/../following-sibling::*/following-sibling::*/a" +
                    "/div[@class='icon-small-delete']");

    private By CHECKBOX_TO_CONFIRM_DELETE = By.xpath("//span[@class='dialog-confirm-busy']/following::*");

    private By OK_DELETE_PROJECT_BUTTON = By.xpath("//div[@id='deleteDialog']/div" +
            "[@class='button-group dialog-buttons-highlighted']" +
            "/a[@class='button button-ok button-left button-positive dialog-action-default']");

    private By PROJECT_ADDED_MESSAGE = By.xpath("//div[text()='Successfully added the new project.']");

    private static By PROJECT_DELETED_MESSAGE = By.xpath("//div[text()='Successfully deleted the project.']");

    @Override
    protected void openPage() {
        driver.get(new ReadProperties().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return waiters.isElementDisplayed(By.xpath("//a[text()='Projects']"));
    }

    public WebElement getDeleteProjectButton() {
        return waiters.getElementBy(DELETE_BUTTON);
    }

    public WebElement getConfirmDeleteCheckbox() {
        return waiters.getElementBy(CHECKBOX_TO_CONFIRM_DELETE);
    }

    public WebElement getConfirmDeleteButton() {
        return waiters.getElementBy(OK_DELETE_PROJECT_BUTTON);
    }

    public String getProjectAddedMessage() {
        return driver.findElement(PROJECT_ADDED_MESSAGE).getText();
    }

    public String getProjectDeletedMessage() {
        return driver.findElement(PROJECT_DELETED_MESSAGE).getText();
    }
}