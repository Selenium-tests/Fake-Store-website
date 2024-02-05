Feature: Checking the "Przeczytałem/am i akceptuję regulamin" checkbox

  Background:
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The checkout page is open
    And The payment details form is filled
    And The credit card form is filled

  @BTN_noTermsAccepted
  Scenario: I am testing clicking the "Buy and pay" button without checking the "I have read and accept the regulations" checkbox.
    When The user clicks the "Kupuję i płacę" button
    Then A message about not accepting the terms was displayed
    And The error message on the checkout page is "Proszę przeczytać i zaakceptować regulamin sklepu aby móc sfinalizować zamówienie."
