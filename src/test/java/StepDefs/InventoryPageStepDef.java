package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.And;
import pageObjects.InventoryPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InventoryPageStepDef extends BaseClass {
    InventoryPage inventoryPage= new InventoryPage(driver);

    @And("I verify I am on Inventory page")
    public void iVerifyIAmOnInventoryPage() {
        assertEquals(inventoryPage.getTitle(),"Swag Labs");
        assertTrue(inventoryPage.isLogoDisplayed());
    }
    @And("I add {int} items to the cart")
    public void iAddItemsToTheCart(int itemsCount) {
        inventoryPage.addItemsToCart(itemsCount);
    }

    @And("I verify {string} items are added to the cart")
    public void iVerifyItemsAreAddedToTheCart(String itemsCount) {
        assertEquals(inventoryPage.getText(), itemsCount);
        inventoryPage.clickOnCart();
    }
}
