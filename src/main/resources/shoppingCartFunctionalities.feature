Feature: Shopping cart functionalities

  Background: The product is the shopping cart
    Given The product has been added to the shopping cart
    And The shopping cart page is open

  Scenario Outline: Changing the amount of the product with correct value
    When The user types the <amount> as amount of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product has been changed

    Examples:
    |amount|
    |"4"   |


  Scenario: Removing a product from the shopping cart
    When The user clicks the 'Remove' button
    Then The shopping cart is empty
