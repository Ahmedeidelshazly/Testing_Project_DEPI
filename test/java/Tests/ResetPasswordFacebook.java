package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage extends PageBase {

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);  // Initialize the elements
    }

    // Facebook Login Elements
    @FindBy(id = "email")
    WebElement emailField;  // Facebook's email input field

    @FindBy(id = "pass")
    WebElement passwordField;  // Facebook's password input field

    @FindBy(name = "login")
    WebElement loginButton;  // Facebook's login button

    @FindBy(xpath = "//div[contains(text(), 'incorrect')]")
    public WebElement loginErrorMessage;  // Example of a possible error message element

    // Forgot Password Elements
    @FindBy(linkText = "Forgotten password?")
    WebElement forgotPasswordLink;  // Link to reset password

    @FindBy(id = "identify_email")
    WebElement resetEmailField;  // Input for email/phone number for password reset

    @FindBy(name = "did_submit")
    WebElement searchButton;  // Button to search for the account

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;  // Button to continue the reset process after selecting an account

    // Method to log in to Facebook
    public void loginToFacebook(String emailAddress, String password) throws InterruptedException {
        Thread.sleep(2000);  // Wait for the page to load
        emailField.sendKeys(emailAddress);  // Enter email
        passwordField.sendKeys(password);  // Enter password
        loginButton.click();  // Click the login button
        Thread.sleep(5000);  // Wait for the login action to process
    }

    // Method to initiate the reset password process
    public void resetPassword(String emailAddress) throws InterruptedException {
        forgotPasswordLink.click();  // Click the "Forgotten password?" link
        Thread.sleep(2000);  // Wait for the reset page to load

        resetEmailField.sendKeys(emailAddress);  // Enter the email address for resetting password
        searchButton.click();  // Search for the account
        Thread.sleep(3000);  // Wait for account identification

        continueButton.click();  // Continue the reset process
        Thread.sleep(3000);  // Wait for confirmation page
    }

    // Method to check if there is a login error message
    public boolean isLoginErrorVisible() {
        try {
            return loginErrorMessage.isDisplayed();  // Return true if the error message is displayed
        } catch (Exception e) {
            return false;  // If no error is found, return false
        }
    }
}
