Feature: Credit card number

  Background:
    Given A product has been added to the shopping cart
    And The checkout page is open

  @CN_CorrectNumber
  Scenario Outline: I test the credit card form using a correct card number
    ##When The user clicks the 'Przejdź do płatności' button
    When The user types the <cardNumber> as a card number
    And Types "09/25" as an expiration date
    And Types <CVC> as a CVC
    And Fills the payment details form
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The order confirmation page has been opened

    Examples:
    |cardNumber           |CVC   |
    |"4242424242424242"   |"332" |
    |"4000056655665556"   |"443" |
    |"5555555555554444"   |"333" |
    |"2223003122003222"   |"233" |
    |"5200828282828210"   |"122" |
    |"5105105105105100"   |"231" |
    |"378282246310005"    |"4421"|
    |"371449635398431"    |"3331"|
    |"6011111111111117"   |"331" |
    |"6011000990139424"   |"133" |
    |"6011981111111113"   |"233" |
    |"6011981111111113"   |"133" |
    |"3056930009020004"   |"332" |
    |"36227206271667"     |"331" |
    |"6555900000604105"   |"233" |
    |"3566002020360505"   |"233" |
    |"6200000000000005"   |"231" |
    |"6200000000000047"   |"808" |
    |"6205500000000000004"|"435" |

  @CN_IncorrectNumber
  Scenario: I test the credit card form using an incorrect card number
    When The user clicks the 'Przejdź do płatności' button
    And Types "3782 822463 33332" as a card number
    Then The message about an incorrect card number has been displayed
    And The text of the invalid card number message is "Numer karty nie jest prawidłowym numerem karty kredytowej."

  @CN_Incomplete
  Scenario: I am testing a credit card form using an incomplete card number
    When The user clicks the 'Przejdź do płatności' button
    And Types "3782 822463" as a card number
    And Types "" as an expiration date
    Then The message about incomplete card number has been displayed
    And The text of the invalid card number message is "Numer karty jest niekompletny."

  @CN_BlankField
  Scenario: I am testing the credit card form without providing the card number
    When The user clicks the 'Przejdź do płatności' button
    And Types "09/25" as an expiration date
    And Types "233" as a CVC
    And Fills the payment details form
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about incomplete card number has been displayed
    And The text of the invalid card number message is "Numer karty jest niekompletny."
