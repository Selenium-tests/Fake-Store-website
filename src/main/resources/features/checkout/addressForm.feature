Feature: Clicking the "Kupuję i płacę" button

  Background:
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The checkout page is open
    And The credit card form is filled

  @BTN_withoutFirstName
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Imię" field.
    When The user fills the address form leaving the 'Imię' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Imię' field on the checkout page has been displayed
    And The error message on the checkout page is "Imię płatnika jest wymaganym polem."

  @BTN_withoutLastName
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Nazwisko" field.
    When The user fills the address form leaving the 'Nazwisko' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Nazwisko' field on the checkout page has been displayed
    And The error message on the checkout page is "Nazwisko płatnika jest wymaganym polem."

  @BTN_withoutAddress
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Ulica" field.
    When The user fills the address form leaving the 'Ulica' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Ulica' field on the checkout page has been displayed
    And The error message on the checkout page is "Ulica płatnika jest wymaganym polem."

  @BTN_withoutPostcode
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Kod pocztowy" field.
    When The user fills the address form leaving the 'Kod pocztowy' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Kod pocztowy' field on the checkout page has been displayed
    And The error message on the checkout page is "Kod pocztowy płatnika jest wymaganym polem."

  @BTN_withoutCity
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Miasto" field.
    When The user fills the address form leaving the 'Miasto' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Miasto' field on the checkout page has been displayed
    And The error message on the checkout page is "Miasto płatnika jest wymaganym polem."

  @BTN_withoutPhone
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Telefon" field.
    When The user fills the address form leaving the 'Telefon' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Telefon' field on the checkout page has been displayed
    And The error message on the checkout page is "Telefon płatnika jest wymaganym polem."

  @BTN_withoutEmail
  Scenario: I am testing clicking the "Kupuję i płacę" button without filling in the "Adres email" field.
    When The user fills the address form leaving the 'Adres email' field blank
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The message about blank 'Adres email' field on the checkout page has been displayed
    And The error message on the checkout page is "Adres email płatnika jest wymaganym polem."