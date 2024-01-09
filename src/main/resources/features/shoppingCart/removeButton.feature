Feature: Remove button

  Background:
    Given A product is in the shopping cart
    And The shopping cart page is open

  @SCCRemovingProduct
  Scenario: Removing a product from the shopping cart
    When The user clicks the 'Remove' button
    Then The shopping cart is empty
    And The message about empty shopping cart is displayed
    And The empty shopping cart message is: "Twój koszyk jest pusty."
