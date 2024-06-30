package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.FinishPage;

public class FinishPageStepDef extends BaseClass {
    FinishPage finishPage=new FinishPage(driver);

    @Then("I should see the finish page")
    public void i_should_see_the_finish_page() {
        Assert.assertEquals(finishPage.getThankYouText(),"Thank you for your order!");
    }

    @Then("I click on back home button")
    public void i_click_on_back_home_button() {
        finishPage.clickBackToProductsButton();
    }
}
