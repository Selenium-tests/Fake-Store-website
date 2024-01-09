Feature: Adding to the shopping cart

    Background: 
      Given The page with url "https://fakestore.testelka.pl/" is open
  
    Scenario Outline: I test adding product to the shopping cart
      When The user clicks on the <number> product link from the <category> category
      And Clicks the 'Dodaj do koszyka' button
      Then The product has been added to the shopping cart
      And The message about adding the product to the cart was displayed
      And The product is in the shopping cart
      And Product name and price match

      Examples:
      |number|category |
      |0     |"Nowości"|