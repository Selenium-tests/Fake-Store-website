Feature: Adding to the shopping cart

  Scenario Outline: Adding product to the shopping cart
    Given The user is on the home page
    When The user clicks the 'Dodaj do koszyka' button of <number> product from category: <category>
    And Waits until the 'Zobacz koszyk' button is visible
    Then The product has been added to the shopping cart

    Examples:
    |number|category     |
    |2     |"Nowości"    |
    |2     |"Popularne"  |
    |0     |"W promocji" |
    |3     |"Bestsellery"|
