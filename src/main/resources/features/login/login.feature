Feature: Login

  Background:
    Given The user goes to the login page

  @LFCorrectCredentials
  Scenario: I test the login form using correct credentials
    When The user types a correct email address "my_email@gmail.com"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The user is logged in

  @LFIncorrectUsername
  Scenario: I test login with an incorrect username
    When The user types an incorrect username "theUser1"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The incorrect username message has been displayed
    And The error message text is "Błąd: brak theUser1 wśród zarejestrowanych w witrynie użytkowników. Jeśli nie masz pewności co do nazwy użytkownika, użyj adresu e-mail."

  @LFIncorrectEmail
  Scenario: I test using an incorrect email address
    When The user types an incorrect email address "the_user2@gmail.com"
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The incorrect email address message has been displayed
    And The error message text is "Nieznany adres e-mail. Proszę sprawdzić ponownie lub wypróbować swoją nazwę użytkownika."

  @LFBlankPasswordField
  Scenario: Blank username or password field
    When The user leaves the username or password field blank
    And Types a correct password "secret_password"
    And Clicks the submit button
    Then The blank username or email address field message has been displayed
    And The error message text is "Błąd: Nazwa użytkownika jest wymagana."

  @LFBIncorrectPassword
  Scenario: I test using an incorrect password
    When The user types a correct email address "my_email@gmail.com"
    And Types an incorrect password "secret_password_11234"
    And Clicks the submit button
    Then The incorrect password message has been displayed
    And The error message text is "Błąd: dla adresu e-mail my_email@gmail.com podano nieprawidłowe hasło. Nie pamiętasz hasła?"

  @LFBlankPasswordField
  Scenario: Blank password field
    When The user types a correct email address "my_email@gmail.com"
    And Leaves the password field blank
    And Clicks the submit button
    Then The blank password field has been displayed
    And The error message text is "Błąd: pole hasła jest puste."