package pageObjects;

import BaseTest.BaseClass;
import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends BaseClass {
    private final WebDriver driver;
    WaitHelper waitHelper;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(xpath="//span[@class='title']")
    WebElement addressTitle;

    @FindBy(id="firstName")
    WebElement firstNameInput;

    @FindBy(id="lastName")
    WebElement lastNameInput;

    @FindBy(id="postal-code")
    WebElement address1Input;

    @FindBy(id="continue")
    WebElement continueButton;

    public String getAddressPageTitle(){
        return addressTitle.getText();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterZipcode(String zipcode) {
        address1Input.sendKeys(zipcode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
