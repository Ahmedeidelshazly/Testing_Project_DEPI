public class FacebookResetPasswordTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();  // Initialize WebDriver (Chrome in this case)
        driver.get("https://www.facebook.com/");  // Navigate to Facebook login page

        FacebookLoginPage loginPage = new FacebookLoginPage(driver);  // Initialize Facebook login page

        // Reset password process
        loginPage.resetPassword("testemail@example.com");

        // Close the browser
        driver.quit();
    }
}
