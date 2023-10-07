Feature: Address forms

  Background:
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"

  #Scenario Outline: I test the Shipping address form
   # And The "Adres do wysyłki" page is open
   # When An user goes to the "Adres rozliczeniowy" editor
   # And Types <firstName> as first name
   # And Types <lastName> as last name
   # And Types <company> as a company
   # And Types <address> as an address
   # And Types <postcode> as a postcode
   # And Types <city> as a city

   # Examples:
   # |firstName|lastName|company|address|postcode|city|
   # |"Jan"    |"Kowalski"|"Drutex"|"ul. Malanowskiego 3A"|"44-200"|"Lublin"|


  Scenario Outline: I test the Billing Address form
    When An user goes to the "Adres rozliczeniowy" form
    And Types <firstName> as first name
    And Types <lastName> as last name
    And Types <company> as a company
    And Types <address> as an address
    And Types <postcode> as a postcode
    And Types <city> as a city
    And Types <phoneNumber> as a phone number
    And Types <email> as a email

    Examples:
    |firstName|lastName|company|address|postcode|city|phoneNumber|email|
    |"Jan"    |"Kowalski"|"Drutex"|"ul. Malanowskiego 3A"|"44-200"|"Lublin"|"333444555"|"my@gmail.com"|