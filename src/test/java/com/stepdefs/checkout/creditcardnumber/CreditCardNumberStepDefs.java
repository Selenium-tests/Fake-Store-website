package com.stepdefs.checkout.creditcardnumber;

import qa.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.pages.checkout.CheckoutPage;

public class CreditCardNumberStepDefs {

    private final CheckoutPage checkoutPage;
    private final TestUtil testUtil;

    public CreditCardNumberStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        checkoutPage = new CheckoutPage(testUtil.getDriver());
    }

    @When("The user types the {string} as a card number")
    @And("Types {string} as a card number")
    public void typesCardNumber(String cardNumber) {

        checkoutPage.getCreditCardForm().setCardNumber(cardNumber);
    }

    @When("The user types {string} as an expiration date")
    @And("Types {string} as an expiration date")
    public void typesExpirationDate(String expirationDate) {

        checkoutPage.getCreditCardForm().setExpirationDate(expirationDate);
    }

    @And("Types {string} as a CVC")
    public void typesCVC(String CVC) {

        checkoutPage.getCreditCardForm().setCVC(CVC);
    }

    @Then("The order confirmation page has been opened")
    public void theOrderConfirmationPageHasBeenOpened() {

        Assert.assertTrue(testUtil.getDriver().getCurrentUrl().contains("https://fakestore.testelka.pl/zamowienie/zamowienie-otrzymane/"));
    }

    @Then("The message about an incorrect card number has been displayed")
    @Then("The message about incomplete card number has been displayed")
    @Then("The message about incorrect month has been displayed")
    public void theMessageAboutAnIncorrectCardNumberHasBeenDisplayed() {

        try {
            checkoutPage.getCreditCardForm().waitForIncorrectCardNumberMessageLocator();
        } catch (Exception e) {
            Assert.fail("The message is not visible");
        }
    }

    @And("The text of the invalid card number message is {string}")
    @And("The message text for the invalid month is {string}")
    public void theIncorrectCardNumberMessageTextIs(String message) throws IllegalAccessException {

        Assert.assertEquals(checkoutPage.getCreditCardForm().getIncorrectCardNumberMessageText(), message);
    }
}