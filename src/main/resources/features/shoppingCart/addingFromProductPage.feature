Feature: Adding to the shopping cart

    Background: 
      Given The page with url "https://fakestore.testelka.pl/product/gran-koscielcow/" is open
  
    Scenario: Adding product from the product page
      And The user clicks the "Dodaj do koszyka" button
      And The message about adding the product to the cart was displayed
      And The opened shopping cart is not empty
      And Product name and price match
