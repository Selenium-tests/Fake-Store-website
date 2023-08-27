package steps.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/login.feature",
        plugin = { "pretty", "html:target/cucumber-reports/login.html" }
)
public class LoginRunner {
}
