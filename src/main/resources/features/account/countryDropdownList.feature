Feature: Country drop-down list

  Background:
    Given The user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And The "Adres rozliczeniowy" form is open

  @CDLCorrectCityName
  Scenario Outline: Correct country name
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
  Scenario Outline: Incorrect country name
    When An user clicks the country drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is displayed

    Examples:
      |country        |
      |"Urugua_y"     |
      |"!Germany"     |
      |"United_#$%#$ "|
      |"R_____a"      |