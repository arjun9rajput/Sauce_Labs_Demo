package pageObjects;

import BaseTest.BaseClass;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseClass {
    private final WebDriver driver;
    WaitHelper waitHelper;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement cartTitle;

    @FindBy(xpath = "//div[@class='cart_item']")
    public WebElement cartItems;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public WebElement removeButton;

    public String getCartTitle() {
        return cartTitle.getText();
    }

    public int getCartItemsCount() {
        List<WebElement> items=driver.findElements((By) cartItems);
        return items.size();
    }

    public void clickCheckoutButton() {
        waitHelper.waitForElement(checkoutButton, 10);
        checkoutButton.click();
    }

    public void clickOnRemoveButton(){
        List<WebElement> buttons = driver.findElements((By) removeButton);

        // Check if there are any buttons found
        if (!buttons.isEmpty()) {
            // Click on the first button
            buttons.get(0).click();
            System.out.println("First button clicked successfully!");
        } else {
            System.out.println("No buttons found with the specified locator.");
        }
    }
}
