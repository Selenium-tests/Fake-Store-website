Feature: Adding to the shopping cart

    Background:
      Given The page with url "https://fakestore.testelka.pl/" is open
  
    Scenario: Adding product from the product page
      And The user goes to the page with the url "https://fakestore.testelka.pl/product/gran-koscielcow/"
      And Enters "2" as the quantity
      And Clicks the "Dodaj do koszyka" button
      And Goes to the page with the url "https://fakestore.testelka.pl/product/grecja-limnos/"
      And Enters "3" as the quantity
      And Clicks the "Dodaj do koszyka" button
      Then The shopping cart is not empty
      And The number of products is correct
      And Product data matches the data displayed on the product page
