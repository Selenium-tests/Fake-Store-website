Feature: Product quantity field

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  @SCCQtyCorrectValue
  Scenario Outline: Correct quantity
    When The user types the <quantity> as quantity of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The quantity of the product has been changed

    Examples:
    |quantity|
    |"1"     |
    |"2"     |
    |"11901" |
    |"11902" |

  @SCCQtyIncorrectValue
  Scenario Outline: Incorrect quantity
    When The user types the <quantity> as quantity of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The message about incorrect quantity value is displayed
    And The validation message is: <message>

    Examples:
    |quantity|message                                  |
    |"11903" |"Wartość nie może być większa niż 11902."|
    |"-1"    |"Wartość nie może być mniejsza niż 0."   |

  @SCCQtyZeroValue
  Scenario: Zero as the quantity
    When The user types the "0" as quantity of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The shopping cart is empty
    And The message about empty shopping cart is displayed
    And The empty shopping cart message is: "Twój koszyk jest pusty."

  @SCCNotANumber
  Scenario Outline: Not a number
    When The user types the <quantity> as not a number
    And Clicks the 'Zaktualizuj koszyk' button
    Then The message about incorrect quantity value is displayed
    And The validation message is: "Wpisz liczbę."

    Examples:
    |quantity|
    |","     |
    |"."     |