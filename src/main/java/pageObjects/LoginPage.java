package pageObjects;

import helpers.WaitHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.bidi.browsingcontext.Locator.xpath;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(id = "user-name")
    public WebElement usernameInput;

    @FindBy(id = "password ")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    WaitHelper waitHelper;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void goToUrl(String url){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (isAlertPresent(wait)) {
            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Accept the alert
            alert.accept();

            // Print a message indicating the alert was accepted
            System.out.println("Alert accepted successfully!");
        }
    }
    public static boolean isAlertPresent(WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        waitHelper.waitForElement(loginButton, 10);
        driver.findElement((By) loginButton).click();
    }

}
