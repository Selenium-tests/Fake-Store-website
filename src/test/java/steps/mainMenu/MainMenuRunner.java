package steps.mainMenu;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/mainMenu.feature",
        plugin = { "pretty", "html:target/cucumber-reports/main-menu.html" }
)
public class MainMenuRunner {
}
