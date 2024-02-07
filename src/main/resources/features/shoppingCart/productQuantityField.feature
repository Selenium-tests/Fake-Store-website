Feature: Product quantity field

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  @SCCQtyCorrectValue
  Scenario Outline: Correct quantity
    When The user types the <quantity> as quantity of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The amount of the product is correct
    And The quantity of the product is correct

    Examples:
    |quantity|
    |"1"     |
    |"2"     |
    |"11771" |
    |"11772" |

  @SCCQtyIncorrectValue
  Scenario Outline: Incorrect quantity
    When The user types the <quantity> as quantity of the product
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

    Examples:
    |quantity|
    |"11773" |
    |"-1"    |


  @SCCNotANumber
  Scenario Outline: Not a number
    When The user types the <quantity> as not a number
    And Clicks the 'Zaktualizuj koszyk' button
    Then The validation message is displayed

    Examples:
    |quantity|
    |","     |
    |"."     |