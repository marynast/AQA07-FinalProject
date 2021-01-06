package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class TestCasePage extends BasePage {

    private By ATTACHMENT_SELECTOR=By.className("markdown-img");
    private By TEST_CASE_SAVED_MESSAGE = By.xpath("//div[text()='Successfully added the new test case.']");

    public TestCasePage(WebDriver driver) {
        super(driver, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean attachmentIsDisplayed(){
        try {
            return waiters.isElementDisplayed(ATTACHMENT_SELECTOR);
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean TestCaseSavedTextIsDisplayed() {
        try {
            return waiters.isElementDisplayed(TEST_CASE_SAVED_MESSAGE);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
