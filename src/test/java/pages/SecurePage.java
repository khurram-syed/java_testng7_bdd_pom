
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecurePage {
    WebDriver driver;
    By securePageBanner = By.id("flash");

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSecurePageBanner() {

        WebElement ele1 = waitForElementToBeVisible(By.id("flash"));
        String flashText = ele1.getText();
        System.out.println("Flash Text : "+flashText);
        return flashText;
    }

    public WebElement waitForElementToBeVisible(By locator){

        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
