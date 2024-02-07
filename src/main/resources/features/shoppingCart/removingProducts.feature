Feature: Remove button

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  @SCCRemovingWithButton
  Scenario: Removing a product with the remove button
    When The user clicks the 'Remove' button
    Then The shopping cart is empty
    Then The message about empty shopping cart is displayed
    And The empty shopping cart message is: "Twój koszyk jest pusty."

  @SCCRemovingWithQuantityField
  Scenario: Removing a product with the quantity field
    When The user enters the zero value in the quantity field
    And Clicks the 'Zaktualizuj koszyk' button
    Then The shopping cart is empty
    And The empty shopping cart message is: "Twój koszyk jest pusty."


