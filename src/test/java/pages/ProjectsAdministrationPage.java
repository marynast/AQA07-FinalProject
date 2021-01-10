package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browserService.ReadProperties;

public class ProjectsAdministrationPage extends BasePage {

    private String ENDPOINT = "index.php?/admin/projects/overview";

    private By DELETE_BUTTON =
            By.xpath("//tr/td/a[text()='Project by Marina']/../following-sibling::*/following-sibling::*/a" +
                    "/div[@class='icon-small-delete']");

    private By CHECKBOX_TO_CONFIRM_DELETE = By.xpath("//span[@class='dialog-confirm-busy']/following::*");

    private By OK_DELETE_PROJECT_BUTTON = By.xpath("//div[@id='deleteDialog']/div" +
            "[@class='button-group dialog-buttons-highlighted']" +
            "/a[@class='button button-ok button-left button-positive dialog-action-default']");

    private By PROJECT_ADDED_MESSAGE = By.xpath("//div[text()='Successfully added the new project.']");

    private static By PROJECT_DELETED_MESSAGE = By.xpath("//div[text()='Successfully deleted the project.']");

    private By PROJECT_WITH_251_Characters = By.xpath("//a[text() = '251rper austor nique vitae temous qurm pellentesque " +
            "nyc npm aliqaam sim it turtor ccnsequat ed parta nybh vinenatis ctas sid " +
            "ftlis etet relit bliquet sagdttis sd cfnsectetur pueus dt favcibus pulbinar elsmentum intdger enfm ngque vblutpat ic tincrdun']");

    public ProjectsAdministrationPage(BrowserService browserService) {
        super(browserService, false);
    }


    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(By.xpath("//a[text()='Projects']"));
    }

    public WebElement getDeleteProjectButton() {
        return browserService.getWaiters().getElementBy(DELETE_BUTTON);
    }

    public WebElement getConfirmDeleteCheckbox() {
        return browserService.getWaiters().getElementBy(CHECKBOX_TO_CONFIRM_DELETE);
    }

    public WebElement getConfirmDeleteButton() {
        return browserService.getWaiters().getElementBy(OK_DELETE_PROJECT_BUTTON);
    }

    public String getProjectAddedMessage() {
        return browserService.getWaiters().getElementBy(PROJECT_ADDED_MESSAGE).getText();
    }

    public String getProjectDeletedMessage() {
        return driver.findElement(PROJECT_DELETED_MESSAGE).getText();
    }

    public String getCurrentProject(){
        return browserService.getWaiters().getElementBy(PROJECT_WITH_251_Characters).getText();
    }
}