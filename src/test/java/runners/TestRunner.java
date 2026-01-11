
package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {"html:reports/cucumber-html-reports/report.html"},
        monochrome = true
        //tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
