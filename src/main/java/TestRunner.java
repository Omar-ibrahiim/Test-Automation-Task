import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/features/Task.feature",
        glue= {"StepDefinition"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true)

public class TestRunner {
}
