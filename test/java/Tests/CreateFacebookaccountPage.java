public class FacebookCreateAccountTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();  // Initialize WebDriver (Chrome in this case)
        driver.get("https://www.facebook.com/r.php");  // Navigate to the Facebook "Create Account" page

        FacebookCreateAccountPage createAccountPage = new FacebookCreateAccountPage(driver);  // Initialize page

        // Create a new Facebook account
        createAccountPage.createNewFacebookAccount(
            "John", "Doe", "johndoe@example.com", "password123",
            "10", "May", "1995", "Male"
        );

        // Check for errors
        if (createAccountPage.isCreateAccountErrorVisible()) {
            System.out.println("Account creation error occurred.");
        } else {
            System.out.println("Account created successfully.");
        }

        driver.quit();  // Close the browser
    }
}
