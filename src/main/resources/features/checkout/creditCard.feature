Feature: Checkout

  Background:
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open

  #Scenario: I test clicking the "Przejdź do płatności" button
    #When The user clicks the 'Przejdź do płatności' button
    #Then The page with url "https://fakestore.testelka.pl/zamowienie/" has been opened
    
  Scenario: I test the credit card form using correct data
    When The user clicks the 'Przejdź do płatności' button
    And Types "4242424242424242" as card number
    And Types "09/25" as expiration date
    And Types "2333" as CVC
    And Fills the payment details form
    And Accepts terms
    And Clicks the "Kupuję i płacę" button
    Then The order confirmation page has been opened