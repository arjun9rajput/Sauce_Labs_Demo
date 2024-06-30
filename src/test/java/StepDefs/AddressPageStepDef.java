package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.AddressPage;

public class AddressPageStepDef extends BaseClass{
    AddressPage addressPage=new AddressPage(driver);

    @Then("I should see the address page")
    public void verifyAddressPage() {
        Assert.assertEquals(addressPage.getAddressPageTitle(),"Checkout: Your Information");
    }

    @Then("I enter {string} as first name")
    public void enterFirstName(String firstName) {
        addressPage.enterFirstName(firstName);
    }

    @Then("I enter {string} as last name")
    public void enterLastName(String lastName) {
        addressPage.enterLastName(lastName);
    }

    @Then("I enter {string} as zipcode")
    public void enterZipcode(String zipcode) {
        addressPage.enterZipcode(zipcode);
    }

    @Then("I click on continue button")
    public void clickContinue() {
        addressPage.clickContinue();
    }
}
