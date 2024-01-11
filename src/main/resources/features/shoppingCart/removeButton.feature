Feature: Remove button

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  @SCCRemovingProduct
  Scenario: Removing a product from the shopping cart
    When The user clicks the 'Remove' button
    And The message about empty shopping cart is displayed
    And The empty shopping cart message is: "Twój koszyk jest pusty."
