Feature: The "regulamin" link

  Background:
    Given A product has been added to the shopping cart
    And The checkout page is open

  Scenario: I am testing clicking the "regulamin" link
    When The user clicks the "regulamin" link
    Then Information about the regulations has been displayed
