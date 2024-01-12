Feature: Credit card expiration date

  Background:
    Given A product has been added to the shopping cart
    And The checkout page is open
    And The payment details form is filled

  @ED_CorrectDate
  Scenario Outline: I am testing a credit card form using the correct card expiration date
    When The user types the "4242 4242 4242 4242" as a card number
    And Types <expirationDate> as an expiration date
    And Types "233" as a CVC
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The order confirmation page has been opened

    Examples:
    |expirationDate|
    |"12/24"       |
    |"10/35"       |

  @ED_DateInThePast
  Scenario Outline: I am testing the credit card form using date in the past
    When The user types the "4242 4242 4242 4242" as a card number
    And Types <expirationDate> as an expiration date
    And Types "233" as a CVC
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message text for the invalid month is <message>

    Examples:
    |expirationDate|message                                   |
    |"12/23"        |"Data ważności karty już minęła."         |
    |"12/20"       |"Rok ważności karty upłynął w przeszłości"|