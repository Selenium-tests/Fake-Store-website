Feature: Opening the checkout page

  Background:
    Given A product has been added to the shopping cart
    And The shopping cart page is open

  Scenario: The "Przejdź do płatności" button
    When The user clicks the 'Przejdź do płatności' button
    Then The page with url "https://fakestore.testelka.pl/zamowienie/" has been opened