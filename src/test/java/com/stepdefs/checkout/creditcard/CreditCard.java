package com.stepdefs.checkout.creditcard;

import com.testutil.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.factories.AddressFormFactory;
import qa.pages.checkout.CheckoutPage;
import qa.pages.ShoppingCart;


public class CreditCard {

    private final CheckoutPage checkoutPage;

    private final TestUtil testUtil;

    public CreditCard(TestUtil testUtil) {

        this.testUtil = testUtil;

        checkoutPage = new CheckoutPage(testUtil.getDriver());
        checkoutPage.hideNotice();
    }

    @When("The user clicks the 'Przejdź do płatności' button")
    public void theUserClicksTheButton() {

        ShoppingCart shoppingCart = new ShoppingCart(testUtil.getDriver());
        shoppingCart.clickCheckoutButton();
    }

    @And("Types {string} as card number")
    public void typesCardNumber(String cardNumber) {

        checkoutPage.getCreditCardForm().setCardNumber(cardNumber);
    }

    @And("Types {string} as expiration date")
    public void typesExpirationDate(String expirationDate) {

        checkoutPage.getCreditCardForm().setExpirationDate(expirationDate);
    }

    @And("Types {string} as CVC")
    public void typesCVC(String CVC) {

        checkoutPage.getCreditCardForm().setCVC(CVC);
    }

    @And("Accepts terms")
    public void acceptsTerms() {

        checkoutPage.clickTermsCheckbox();
    }

    @And("Fills the payment details form")
    public void fillsThePaymentDetailsForm() {

        checkoutPage.setAddressForm(AddressFormFactory.get(testUtil.getDriver()));
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
}
