Feature: Credit card expiration date

  Background:
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open

  @ED_CorrectDate
  Scenario Outline: I am testing a credit card form using the correct card expiration date
    When The user clicks the 'Przejdź do płatności' button
    And Types "4242 4242 4242 4242" as a card number
    And Types <expirationDate> as an expiration date
    And Types "233" as a CVC
    And Fills the payment details form
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The order confirmation page has been opened

    Examples:
    |expirationDate|
    |"12/23"          |
    |"10/73"          |

  @ED_DateInThePast
  Scenario Outline: I am testing the credit card form using date in the past
    When The user clicks the 'Przejdź do płatności' button
    And Types "4242 4242 4242 4242" as a card number
    And Types <expirationDate> as an expiration date
    And Types "233" as a CVC
    And Fills the payment details form
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message text for the invalid month is <message>

    Examples:
    |expirationDate|message                                   |
    |"09/23"       |"Data ważności karty już minęła."         |
    |"12/22"       |"Rok ważności karty upłynął w przeszłości"|