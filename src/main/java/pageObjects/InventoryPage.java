package pageObjects;

import BaseTest.BaseClass;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InventoryPage extends BaseClass {
    private final WebDriver driver;
    WaitHelper waitHelper;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement logo;

    @FindBy(xpath = "//div[@class='inventory_list']/div")
    WebElement inventoryList;

    @FindBy(xpath="//a[@id='item_{index}_title_link']/div")
    WebElement inventoryItem;

    @FindBy(xpath = "//a[@id='item_{index}_title_link']/../../div/button")
    WebElement inventoryButton;

    @FindBy(xpath = "//div[@class='shopping_cart_badge']")
    WebElement cartBadge;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public  String getText(){
        return cartBadge.getText();
    }
    public void clickOnCart(){
        cartBadge.click();
    }
    public WebElement getInventoryItem(int index) {
        // Replace {index} placeholder in XPath with actual index value
        String xpath = inventoryItem.getAttribute("xpath").replace("{index}", String.valueOf(index));
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement getInventoryButton(int index){
        String xpath = inventoryButton.getAttribute("xpath").replace("{index}", String.valueOf(index));
        return driver.findElement(By.xpath(xpath));
    }

    public void addItemsToCart(int itemsCount){
        List<WebElement> elementList = driver.findElements((By) inventoryList);
        Random r = new Random();
        Set<Integer> s = new HashSet<>();


        System.out.println("Total List Of Items present are " +elementList.size());
        for(int i=0;i<itemsCount;i++ )
        {
            while(true) {
                int num = r.nextInt(elementList.size());
                if (!s.contains(num)) {
                    s.add(num);
                    System.out.println(num);
                    WebElement button =	driver.findElement((By) getInventoryButton(num));
                    if(button.isDisplayed())
                    {
                        button.click();
                        WebElement selected= driver.findElement((By) getInventoryItem(num));
                        System.out.println("Selected Item from Cart List " +selected.getText());
                    }
                    else
                    {
                        System.out.println("Add to Cart Button Not displayed");
                    }
                    break;
                }
                else
                {
                    System.out.println("This Cart Already Selected" +num);
                }
            }
        }

    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
}
