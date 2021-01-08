package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class TestCasePage extends BasePage {

    private By ATTACHMENT_SELECTOR=By.xpath("//div[text()='\n" +
            "\t\t\tPng Image,\n" +
            "\t\t\t111K\t\t\t']");
    private By TEST_CASE_SAVED_MESSAGE = By.xpath("//div[text()='Successfully added the new test case. ']");

    public TestCasePage(BrowserService browserService) {
        super(browserService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(By.id("navigation-cases-details"));
    }

    public boolean attachmentIsDisplayed(){
        try {
            return browserService.getWaiters().isElementDisplayed(ATTACHMENT_SELECTOR);
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean TestCaseSavedTextIsDisplayed() {
        try {
            return browserService.getWaiters().isElementDisplayed(TEST_CASE_SAVED_MESSAGE);
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
