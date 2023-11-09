Feature: Checking the "Przeczytałem/am i akceptuję regulamin" checkbox

  Background:
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open

  @BTN_noTermsAccepted
  Scenario: I am testing clicking the "Buy and pay" button without checking the "I have read and accept the regulations" checkbox.
    When The user clicks the 'Przejdź do płatności' button
    And Fills the credit card form
    And Fills the payment details form
    And Clicks the "Kupuję i płacę" button
    Then A message about not accepting the terms was displayed
    And The error message text is "Proszę przeczytać i zaakceptować regulamin sklepu aby móc sfinalizować zamówienie."
