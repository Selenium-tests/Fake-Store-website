Feature: Login

  Narrative:
  As an user I want to be informed whether the login succeed or failed

  Scenario: I test login with an incorrect username
    Given The user goes to the login page
    When The user types an incorrect username "theUser1"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The incorrect username message has been displayed
    And The error message text is "Błąd: Brak theUser1 wśród zarejestrowanych w witrynie użytkowników. Jeśli nie masz pewności co do nazwy użytkownika, użyj adresu e-mail."

  Scenario: I test using an incorrect email address
    Given The user goes to the login page
    When The user types an incorrect email address "the_user2@gmail.com"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The incorrect email address message has been displayed
    And The error message text is "Nieznany adres e-mail. Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika."

  Scenario: Blank username or password field
    Given The user goes to the login page
    When The user leaves the username or password field blank
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The blank username or email address field message has been displayed
    And The error message text is "Błąd: Nazwa użytkownika jest wymagana."

  Scenario: I test using an incorrect password
    Given The user goes to the login page
    When The user types a correct email address "my_email@gmail.com"
    And Types an incorrect password "secret_password_11234"
    And Clicks the submit button
    Then The incorrect password message has been displayed
    And The error message text is "Błąd: Dla adresu e-mail my_email@gmail.com podano nieprawidłowe hasło. Nie pamiętasz hasła?"

  Scenario: Blank password field
    Given The user goes to the login page
    When The user types a correct email address "my_email@gmail.com"
    And Leaves the password field blank
    And Clicks the submit button
    Then The blank password field has been displayed
    And The error message text is "Błąd: Hasło jest puste."

  Scenario: I test using correct login
    Given The user goes to the login page
    When The user types a correct email address "my_email@gmail.com"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The user is logged in