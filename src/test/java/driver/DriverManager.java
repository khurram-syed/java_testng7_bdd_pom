
package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
          String browser = System.getProperty("browser","chrome").toLowerCase();
          WebDriver driver;
          switch(browser){
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  driver = new FirefoxDriver();
                  break;
              case "edge":
                  WebDriverManager.edgedriver().setup();
                  driver = new EdgeDriver();
                  break;
              case "safari":
                  WebDriverManager.safaridriver().setup();
                  driver = new FirefoxDriver();
                  break;
              case "chrome":
              default:
                  WebDriverManager.chromedriver().setup();
                  driver = new ChromeDriver();
                  break;
          }
            driver.manage().window().maximize();
            DRIVER.set(driver);
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
