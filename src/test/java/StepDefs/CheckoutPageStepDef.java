package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;

public class CheckoutPageStepDef extends BaseClass {
    CheckoutPage checkoutPage= new CheckoutPage(driver);

    @And("I verify checkout page is displayed")
    public void iVerifyCheckoutPageIdDisplayed() {
        Assert.assertEquals(checkoutPage.getCheckoutTitle(),"Checkout: Overview");
    }


    @Then("I verify total items on the checkout page is {int}")
    public void verifyTotalItemsOnCartPage(int expectedTotalItems){
        Assert.assertEquals(checkoutPage.getCartItemsCount(),expectedTotalItems);
    }

    @And("I verify correct total price is displayed")
    public void iVerifyCorrectTotalPriceIsDisplayed() {
        Assert.assertTrue(checkoutPage.getTotalItemPrice());
    }

    @And("I click on finish button")
    public void iClickOnFinishButton() {
        checkoutPage.clickFinishButton();
    }

}
