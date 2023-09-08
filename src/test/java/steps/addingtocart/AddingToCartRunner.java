package steps.addingtocart;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/addingToCart.feature",
        plugin = {"pretty", "html:target/cucumber-reports/adding-to-cart.html"}
)
public class AddingToCartRunner {
}
