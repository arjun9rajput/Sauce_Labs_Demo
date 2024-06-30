package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CartPage;

public class CartPageStepDef extends BaseClass {
    CartPage cartPage= new CartPage(driver);

    @Then("I verify I am on cart page")
    public void landOnCartPage(){
        Assert.assertEquals(cartPage.getCartTitle(),"Your Cart");
    }

    @Then("I click checkout button")
    public void clickCheckoutButton(){
        cartPage.clickCheckoutButton();
    }

    @And("I verify total items on the cart page is {int}")
    public void iVerifyTotalItemsOnTheCartPageIs(int expectedTotalItems) {
        Assert.assertEquals(cartPage.getCartItemsCount(),expectedTotalItems);
    }

    @And("I remove one item from the cart")
    public void iRemoveOneItemFromTheCart() {
        cartPage.clickOnRemoveButton();
    }
}
