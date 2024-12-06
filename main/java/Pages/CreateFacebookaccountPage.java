package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookCreateAccountPage extends PageBase {

    public FacebookCreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);  // Initialize the elements
    }

    // Facebook Create Account fields

    @FindBy(name = "firstname")
    WebElement firstNameField;  // First Name input field

    @FindBy(name = "lastname")
    WebElement lastNameField;  // Last Name input field

    @FindBy(name = "reg_email__")
    WebElement emailField;  // Email or phone number input field

    @FindBy(name = "reg_passwd__")
    WebElement passwordField;  // New password input field

    @FindBy(name = "birthday_day")
    WebElement birthdayDayDropdown;  // Day dropdown for birthday

    @FindBy(name = "birthday_month")
    WebElement birthdayMonthDropdown;  // Month dropdown for birthday

    @FindBy(name = "birthday_year")
    WebElement birthdayYearDropdown;  // Year dropdown for birthday

    @FindBy(xpath = "//label[text()='Male']/following-sibling::input")
    WebElement genderMaleRadioButton;  // Male radio button

    @FindBy(xpath = "//label[text()='Female']/following-sibling::input")
    WebElement genderFemaleRadioButton;  // Female radio button

    @FindBy(name = "websubmit")
    WebElement signUpButton;  // Sign-Up button

    @FindBy(xpath = "//div[contains(text(), 'error')]")
    public WebElement createAccountErrorMessage;  // Example of a possible error message element


    // Method to create a new Facebook account
    public void createNewFacebookAccount(String firstName, String lastName, String email, String password, String day, String month, String year, String gender) throws InterruptedException {
        Thread.sleep(2000);  // Wait for the page to load
        
        // Fill out the account creation form
        firstNameField.sendKeys(firstName);  // Enter first name
        lastNameField.sendKeys(lastName);  // Enter last name
        emailField.sendKeys(email);  // Enter email or phone number
        passwordField.sendKeys(password);  // Enter new password

        // Select birthday (day, month, year)
        birthdayDayDropdown.sendKeys(day);  // Select birth day
        birthdayMonthDropdown.sendKeys(month);  // Select birth month
        birthdayYearDropdown.sendKeys(year);  // Select birth year

        // Select gender
        if (gender.equalsIgnoreCase("male")) {
            genderMaleRadioButton.click();
        } else if (gender.equalsIgnoreCase("female")) {
            genderFemaleRadioButton.click();
        }

        // Click the "Sign Up" button
        signUpButton.click();
        Thread.sleep(5000);  // Wait for the sign-up process to complete
    }

    // Method to check if there is a create account error message
    public boolean isCreateAccountErrorVisible() {
        try {
            return createAccountErrorMessage.isDisplayed();  // Return true if the error message is displayed
        } catch (Exception e) {
            return false;  // If no error is found, return false
        }
    }
}
