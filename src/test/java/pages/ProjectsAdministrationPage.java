package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProjectsAdministrationPage extends BasePage {

    private By DELETE_BUTTON =
            By.xpath("//tr/td/a[text()='Test project']/../following-sibling::*/following-sibling:" +
                    ":*/a/div[@class='icon-small-delete']");

    private By CHECKBOX_TO_CONFIRM_DELETE = By.xpath("//*[@class='icon-progress-inline']/following::input");

    private By OK_DELETE_PROJECT_BUTTON = By.xpath("//*[@class='icon-progress-inline']/following::a[1]");

    private By PROJECT_ADDED_MESSAGE = By.xpath("//div[text()='Successfully added the new project.']");

    private static By PROJECT_DELETED_MESSAGE = By.xpath("//div[text()='Successfully deleted the project.']");

    private By PROJECT_WITH_251_Characters = By.xpath("//a[text() = '251rper austor nique vitae temous qurm pellentesque " +
            "nyc npm aliqaam sim it turtor ccnsequat ed parta nybh vinenatis ctas sid " +
            "ftlis etet relit bliquet sagdttis sd cfnsectetur pueus dt favcibus pulbinar elsmentum intdger enfm ngque vblutpat ic tincrdun']");

    private static By ALL_PROJECTS_BUTTON = By.id("navigation-sub-projects");
    private static By DASHBOARD_BUTTON = By.id("navigation-dashboard");

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
    public WebElement getAllProjectsButton (){
        return browserService.getWaiters().getElementBy(ALL_PROJECTS_BUTTON);
    }

    public WebElement getDashboard (){
        return browserService.getWaiters().getElementBy(DASHBOARD_BUTTON);
    }
}