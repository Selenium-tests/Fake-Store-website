package steps.couponRedemption;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "./src/main/resources/couponRedemption.feature",
        plugin = { "pretty", "html:target/cucumber-reports/coupon.html" }
)
public class CouponRedemptionRunner {
}
