
package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
          String browser = System.getProperty("browser","chrome").toLowerCase();
          boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

          WebDriver driver;
          switch(browser){
              case "firefox":
                  WebDriverManager.firefoxdriver().setup();
                  FirefoxOptions firefoxOptions = new FirefoxOptions();
                  if (headless) firefoxOptions.addArguments("--headless");
                  driver = new FirefoxDriver(firefoxOptions);
                  break;
              case "edge":
                  WebDriverManager.edgedriver().setup();
                  EdgeOptions edgeOptions = new EdgeOptions();
                  if (headless) edgeOptions.addArguments("--headless");
                  driver = new EdgeDriver(edgeOptions);
                  break;
              case "safari":
                  WebDriverManager.safaridriver().setup();
                  driver = new SafariDriver();
                  break;
              case "chrome":
              default:
                  WebDriverManager.chromedriver().setup();
                  ChromeOptions chromeOptions = new ChromeOptions();
                  if (headless) {
                      chromeOptions.addArguments(
                              "--headless=new",
                              "--disable-gpu",
                              "--window-size=1920,1080",
                              "--no-sandbox",
                              "--disable-dev-shm-usage"
                      );
                  }
                  driver = new ChromeDriver(chromeOptions);
                  break;
          }
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
