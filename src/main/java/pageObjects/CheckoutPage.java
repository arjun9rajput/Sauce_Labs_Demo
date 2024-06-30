package pageObjects;

import BaseTest.BaseClass;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BaseClass {
    private final WebDriver driver;
    WaitHelper waitHelper;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath="//span[@class='title']")
    WebElement checkoutTitle;

    @FindBy(xpath = "//div[@class='cart_item']")
    public WebElement cartItems;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public WebElement inventoryPrice;

    @FindBy(xpath = "//div[@class='summary_info']/div[@class='summary_subtotal_label']")
    public WebElement totalPrice;

    @FindBy(id="finish")
    public WebElement finishButton;

    public String getCheckoutTitle() {
        waitHelper.waitForElement(checkoutTitle, 10);
        return checkoutTitle.getText();
    }

    public int getCartItemsCount() {
        List<WebElement> items=driver.findElements((By) cartItems);
        return items.size();
    }

    public Boolean getTotalItemPrice(){

            List<WebElement> itemPricesElements = driver.findElements((By)inventoryPrice);

            // Sum the prices of the individual items
            double totalCalculatedPrice = 0.0;
            for (WebElement priceElement : itemPricesElements) {
                String priceText = priceElement.getText().replace("$", "").trim();
                double price = Double.parseDouble(priceText);
                totalCalculatedPrice += price;
            }

            // Locate the element containing the total price displayed on the cart page
            WebElement totalPriceElement = driver.findElement((By) totalPrice);
            String totalPriceText = totalPriceElement.getText().replace("Item total: $", "").trim();
            double totalDisplayedPrice = Double.parseDouble(totalPriceText);

            // Compare the summed price with the displayed total price
        return totalCalculatedPrice == totalDisplayedPrice;
    }

    public void clickFinishButton() {
        waitHelper.waitForElement(finishButton, 10);
        finishButton.click();
    }


}
