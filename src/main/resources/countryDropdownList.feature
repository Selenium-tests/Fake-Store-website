Feature: Country drop-down list

  Scenario Outline: I test the country drop-down list from the "Adres rozliczeniowy" page typing a correct country name
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And Goes to the "Adres rozliczeniowy" form
    When An user clicks the country drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is not displayed

    Examples:
    |country  |
    |"Urugwaj"|
    |"Niemcy" |
    |"Libia"  |
    |"Rwanda" |

  Scenario Outline: I test the country drop-down list from the "Adres rozliczeniowy" page typing an incorrect country name
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And Goes to the "Adres rozliczeniowy" form
    When An user clicks the country drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is displayed

    Examples:
      |country        |
      |"Urugua_y"     |
      |"!Germany"     |
      |"United_#$%#$ "|
      |"R_____a"      |