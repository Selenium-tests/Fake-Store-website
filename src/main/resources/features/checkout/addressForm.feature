Feature: Clicking the "Kupuję i płacę" button

  Background:
    Given A product has been added to the shopping cart
    And The checkout page is open
    And The credit card form is filled

  @BTN_withoutFirstName
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Imię" field.
    When The user fills the address form leaving the 'Imię' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Imię' field has been displayed
    And The error message text is "Imię płatnika jest wymaganym polem."

  @BTN_withoutLastName
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Nazwisko" field.
    When The user fills the address form leaving the 'Nazwisko' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Nazwisko' field has been displayed
    And The error message text is "Nazwisko płatnika jest wymaganym polem."

  @BTN_withoutAddress
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Ulica" field.
    When The user fills the address form leaving the 'Ulica' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Ulica' field has been displayed
    And The error message text is "Ulica płatnika jest wymaganym polem."

  @BTN_withoutPostcode
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Kod pocztowy" field.
    When The user fills the address form leaving the 'Kod pocztowy' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Kod pocztowy' field has been displayed
    And The error message text is "Kod pocztowy płatnika jest wymaganym polem."

  @BTN_withoutCity
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Miasto" field.
    When The user fills the address form leaving the 'Miasto' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Miasto' field has been displayed
    And The error message text is "Miasto płatnika jest wymaganym polem."

  @BTN_withoutPhone
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Telefon" field.
    When The user fills the address form leaving the 'Telefon' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Telefon' field has been displayed
    And The error message text is "Telefon płatnika jest wymaganym polem."

  @BTN_withoutEmail
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Telefon" field.
    When The user fills the address form leaving the 'Adres email' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Adres email' field has been displayed
    And The error message text is "Adres email płatnika jest wymaganym polem."