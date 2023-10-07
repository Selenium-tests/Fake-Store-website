Feature: Country drop-down list

  Scenario Outline: I test the country drop-down list from the "Adres rozliczeniowy" page
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And The "Adres do wysyłki" page is open
    When An user clicks the drop-down list arrow
    And Types <country> in the drop-down search field
    Then The message about incorrect country name is not displayed

    Examples:
    |country|
    |"Urugwaj"|