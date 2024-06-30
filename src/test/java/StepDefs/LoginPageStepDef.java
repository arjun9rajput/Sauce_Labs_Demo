package StepDefs;

import BaseTest.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;


import static org.testng.Assert.assertEquals;


public class LoginPageStepDef extends BaseClass {
  LoginPage loginpage=new LoginPage(driver);

    @Given("I am on Swag Labs Login Page")
    public void landOnLoginPage() throws Exception {
        loginpage.goToUrl("https://www.saucedemo.com/");
        assertEquals(loginpage.getTitle(), "Swag Labs");
    }

    @When("I enter username as {string} and password as {string}")
    public void enterUsernameAndPassword(String userName,String password) throws Exception  {
        loginpage.enterUsername(userName);
        loginpage.enterPassword(password);
    }

    @And("I click Login Button")
    public void clickOnLoginButton()  throws Exception{
        loginpage.clickLoginButton();
    }
}
