public class FacebookLoginTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();  // Initialize WebDriver (Chrome in this case)
        driver.get("https://www.facebook.com/");  // Navigate to Facebook login page

        FacebookLoginPage loginPage = new FacebookLoginPage(driver);  // Initialize Facebook login page

        // Perform login
        loginPage.loginToFacebook("testemail@example.com", "testpassword");

        // Check for errors
        if (loginPage.isLoginErrorVisible()) {
            System.out.println("Login error occurred.");
        } else {
            System.out.println("Login successful.");
        }

        driver.quit();  // Close the browser
    }
}
