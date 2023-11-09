Feature: The "regulamin" link

  Background:
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open

  Scenario: I am testing clicking the "regulamin" link
    When The user clicks the 'Przejdź do płatności' button
    And Clicks the "regulamin" link
    Then Information about the regulations has been displayed
