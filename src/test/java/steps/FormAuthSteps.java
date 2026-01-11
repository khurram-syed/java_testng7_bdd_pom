
package steps;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import pages.SecurePage;

import java.time.Duration;

public class FormAuthSteps {
    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage;
    SecurePage securePage;

    @Given("User is on the Login page")
    public void user_on_login_page() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
        securePage = new SecurePage(driver);
    }

    @When("User enters username {string} and password {string}")
    public void enter_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should see message {string}")
    public void verify_login_message(String message) {
        Assert.assertTrue(securePage.getSecurePageBanner().contains(message));
    }

    @Given("User visits the A/B Testing page")
    public void user_visits_ab_testing_page() {
        driver.get("https://the-internet.herokuapp.com/abtest");
    }

    @Then("The page header should contain A/B Test")
    public void verify_ab_test_header() {
        String header = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(header.contains("A/B Test"));
    }

    public WebElement waitForElementToBeVisible(By locator){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
