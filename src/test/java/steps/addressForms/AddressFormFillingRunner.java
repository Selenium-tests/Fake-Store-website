package steps.addressForms;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/main/resources/addressFormFilling.feature",
        plugin = { "pretty", "html:target/cucumber-reports/filling-address-form.html" }
)
public class AddressFormFillingRunner {
}
