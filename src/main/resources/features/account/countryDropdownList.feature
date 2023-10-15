Feature: Country drop-down list

  Background: An user is logged in
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And The "Adres rozliczeniowy" form is open

  @CDLCorrectCityName
  Scenario Outline: I test the country drop-down list from the "Adres rozliczeniowy" page typing a correct country name
    When An user clicks the country drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is not displayed

    Examples:
    |country  |
    |"Urugwaj"|
    |"Niemcy" |
    |"Libia"  |
    |"Rwanda" |

  @CDLIncorrectCityName
  Scenario Outline: I test the country drop-down list from the "Adres rozliczeniowy" page typing an incorrect country name
    When An user clicks the country drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is displayed

    Examples:
      |country        |
      |"Urugua_y"     |
      |"!Germany"     |
      |"United_#$%#$ "|
      |"R_____a"      |