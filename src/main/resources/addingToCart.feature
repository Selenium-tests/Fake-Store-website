Feature: Adding to the shopping cart

  #Scenario Outline: Adding product to the shopping cart from the home page
    #Given The user is on the home page
    #When The user clicks the 'Dodaj do koszyka' button of <number> product from category: <category>
    #And Waits until the 'Zobacz koszyk' button is visible
    #Then The product has been added to the shopping cart

    #Examples:
    #|number|category     |
    #|2     |"Nowości"    |
    #|2     |"Popularne"  |
    #|0     |"W promocji" |
    #|3     |"Bestsellery"|


    Scenario Outline: Adding product to the cart from a product page
      Given The user is on the home page
      When The user clicks on the <number> product link from the <category> category
      And Clicks the 'Dodaj do koszyka' button
      Then The product has been added to the shopping cart
      And The product is in the shopping cart

      Examples:
      |number|category |
      |0     |"Nowości"|