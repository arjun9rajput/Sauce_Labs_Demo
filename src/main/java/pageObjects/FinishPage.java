package pageObjects;

import BaseTest.BaseClass;
import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends BaseClass {
    private final WebDriver driver;
    WaitHelper waitHelper;

    public FinishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath="//h2[@class='complete-header']")
    public WebElement thankYouText;

    @FindBy(id="back-to-products")
    public WebElement backToProductsButton;

    public String getThankYouText() {
        return thankYouText.getText();
    }

    public void clickBackToProductsButton() {
        waitHelper.waitForElement(backToProductsButton, 10);
        backToProductsButton.click();
    }
}
