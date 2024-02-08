Feature: Product quantity field

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  @SCCQtyMinInt
  Scenario: Quantity = MIN INT
    When The user types quantity: "-9007199254740991"
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

  @SCCQtyLessThanMin
  Scenario: Quantity = MIN - 1
    When The user types quantity which is MIN - 1
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

  @SCCQtyMin
  Scenario: Quantity = MIN
    When The user types quantity which is MIN
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product is correct
    And The quantity of the product is correct

  @SCCQtyGreaterThanMin
  Scenario: Quantity = MIN + 1
    When The user types quantity which is MIN + 1
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product is correct
    And The quantity of the product is correct

  @SCCQtyLessThanMax
  Scenario: Quantity = MAX - 1
    When The user types quantity which is MAX - 1
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product is correct
    And The quantity of the product is correct

  @SCCQtyMax
    Scenario: Quantity = MAX
    When The user types quantity which is MAX
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product is correct
    And The quantity of the product is correct

  @SCCQtyGreaterThanMax
  Scenario: Quantity = MAX + 1
    When The user types quantity which is MAX + 1
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

  @SCCQtyFloatingPoint
  Scenario Outline: Floating point
    When The user types quantity: <quantity>
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

    Examples:
    |quantity|
    |"1.2" |
    |"0.3" |
    
  @SCCNotANumber
  Scenario Outline: Not a number
    When The user types quantity: <quantity>
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

    Examples:
    |quantity|
    |"."     |
    |","     |

  @SCCQtyHasSpecialChars
  Scenario Outline: Has special characters
    When The user types quantity: <quantity>
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

    Examples:
      |quantity|
      |"1,2"     |
      |"1-5"     |