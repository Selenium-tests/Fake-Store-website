package com.stepdefs.checkout.creditcardnumber;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.pages.checkout.CheckoutPage;


public class CreditCardNumberStepDefs {

    private final CheckoutPage checkoutPage;
    private final TestUtil testUtil;

    public CreditCardNumberStepDefs(TestUtil testUtil) {

        this.testUtil = testUtil;

        checkoutPage = new CheckoutPage(testUtil.getDriver());
        checkoutPage.hideNotice();
    }

    @And("Types {string} as a card number")
    public void typesCardNumber(String cardNumber) {

        checkoutPage.getCreditCardForm().setCardNumber(cardNumber);
    }

    @And("Types {string} as an expiration date")
    public void typesExpirationDate(String expirationDate) {

        checkoutPage.getCreditCardForm().setExpirationDate(expirationDate);
    }

    @And("Types {string} as a CVC")
    public void typesCVC(String CVC) {

        checkoutPage.getCreditCardForm().setCVC(CVC);
    }

    @And("Clicks the \"Kupuję i płacę\" button")
    public void clicksTheSubmitButton() throws InterruptedException {

        checkoutPage.clickSubmitButton();

        Thread.sleep(6000);
    }

    @Then("The order confirmation page has been opened")
    public void theOrderConfirmationPageHasBeenOpened() {

        Assert.assertTrue(testUtil.getDriver().getCurrentUrl().contains("https://fakestore.testelka.pl/zamowienie/zamowienie-otrzymane/"));
    }

    @Then("The message about an incorrect card number has been displayed")
    @Then("The message about incomplete card number has been displayed")
    @Then("The message about incorrect month has been displayed")
    public void theMessageAboutAnIncorrectCardNumberHasBeenDisplayed() {

        Assert.assertTrue(checkoutPage.getCreditCardForm().isIncorrectCardNumberMessageVisible());
    }

    @And("The text of the invalid card number message is {string}")
    @And("The message text for the invalid month is {string}")
    public void theIncorrectCardNumberMessageTextIs(String message) {

        Assert.assertEquals(checkoutPage.getCreditCardForm().getIncorrectCardNumberMessageText(), message);
    }
}
