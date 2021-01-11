package pages;

import baseEntities.BasePage;
import browserService.BrowserService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class AddTestCasePage extends BasePage {

    private By TEST_CASE_TITLE = By.id("title");
    private By STEPS_DESCRIPTION = By.id("custom_steps");
    private By EXPECTED_RESULT_DESCRIPTION = By.id("custom_expected");
    private By FILE_UPLOAD_ICON = By.xpath("//div[@id='form-controls']/div[5]/label/span/a/" +
            "div[@class='icon-markdown-image']");
    private By ATTACHMENT_DROPZONE = By.id("attachmentDropzone");
    private By EXPECTED_RESULT_DROP_AREA = By.xpath("//span[text()='Drop files here to attach, or click to browse.']");
    private By FILE_UPLOAD = By.cssSelector("input[type=file]");
    private By SAVE_TEST_CASE_BUTTON = By.id("accept");
    private String basePath = new File("").getAbsolutePath();
    public String filePath = basePath+"/src/images/1.png";

    public AddTestCasePage(BrowserService browserService) {
        super(browserService, false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return browserService.getWaiters().isElementDisplayed(By.id("title"));
    }

    public WebElement getTitleField() {
        return browserService.getWaiters().getElementBy(TEST_CASE_TITLE);
    }

    public WebElement getStepsField() {
        return browserService.getWaiters().getElementBy(STEPS_DESCRIPTION);
    }

    public WebElement getExpectedResultField() {
        return browserService.getWaiters().getElementBy(EXPECTED_RESULT_DESCRIPTION);
    }

    public void dropFile(File filePath, WebElement target, int offsetX, int offsetY) {
        if (!filePath.exists())
            throw new WebDriverException("File not found: " + filePath.toString());

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "" +
                        "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(filePath.getAbsoluteFile().toString());
        
    }

    public WebElement expectedResultDropArea() {
        return browserService.getWaiters().getElementBy(EXPECTED_RESULT_DROP_AREA);
    }

    public WebElement getConfirmAddTestCaseButton() {
       return browserService.getWaiters().getElementBy(SAVE_TEST_CASE_BUTTON);
    }

    public WebElement getSaveTestCaseButton() {
        return browserService.getWaiters().getElementBy(SAVE_TEST_CASE_BUTTON);
    }

    public boolean dropAreaIsNotVisible() {
        return browserService.getWaiters().getElementIsNotDisplayed(EXPECTED_RESULT_DROP_AREA);
    }
}