package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class AddTestCasePage extends BasePage {

    private By ADD_TEST_CASE = By.xpath("//a[@class='sidebar-button']");
    private By TEST_CASE_TITLE = By.id("title");
    private By STEPS_DESCRIPTION = By.id("custom_steps");
    private By EXPECTED_RESULT_DESCRIPTION = By.id("custom_expected");
    private By FILE_UPLOAD = By.cssSelector("input[type=file]");
    private By SAVE_TEST_CASE_BUTTON = By.id("accept");
    private String basePath = new File("").getAbsolutePath();
    private String filePath = basePath+"\\src\\images\\1.png";


    public AddTestCasePage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public WebElement getAddTestCasesButton() {
        return waiters.getElementBy(ADD_TEST_CASE);
    }

    public WebElement getTitleField() {
        return waiters.getElementBy(TEST_CASE_TITLE);
    }

    public WebElement getStepsField() {
        return waiters.getElementBy(STEPS_DESCRIPTION);
    }

    public WebElement getExpectedResultField() {
        return waiters.getElementBy(EXPECTED_RESULT_DESCRIPTION);
    }

    public void uploadFile(){
        driver.findElement(FILE_UPLOAD).sendKeys(filePath);
    }

    public WebElement getConfirmAddTestCaseButton() {
        return waiters.getElementBy(SAVE_TEST_CASE_BUTTON);
    }

    public WebElement getSaveTestCaseButton() {
        return driver.findElement(SAVE_TEST_CASE_BUTTON);
    }
}