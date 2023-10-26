Feature: Checkout

  Background:
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open

  Scenario: I test clicking the "Przejdź do płatności" button
    When The user clicks the 'Przejdź do płatności' button
    Then The page with url "https://fakestore.testelka.pl/zamowienie/" has been opened