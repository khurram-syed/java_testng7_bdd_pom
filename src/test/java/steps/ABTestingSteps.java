
package steps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ABTestingSteps {
    WebDriver driver = DriverManager.getDriver();

    @Given("User visits the AB Testing page")
    public void user_visits_ab_testing_page() {
        driver.get("https://the-internet.herokuapp.com/abtest");
    }

    @Then("The page header should contain AB Test")
    public void verify_ab_test_header() {
        String header = driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(header.contains("A/B Test"));
    }
}
