Feature: Coupon redemption

  Scenario Outline: I test using correct plain coupon code
    Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed
    And The <couponDescription> coupon is displayed on the shopping cart summary

    Examples:
    |couponCode             |couponDescription             |
    |"kwotowy250"           |"Kupon: kwotowy250"           |
    |"kwotowy250pojedynczy" |"Kupon: kwotowy250pojedynczy" |
    |"10procent"            |"Kupon: 10procent"            |
    |"kwotowy300bezpromocji"|"Kupon: kwotowy300bezpromocji"|
    |"10procent1"           |"Kupon: 10procent1"           |


  Scenario Outline: I test using the "kwotowy300" coupon code when value of the shopping cart is 3000 zł or greater
    Given The product number <productNumber> from the <category> category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed

    Examples:
    |productNumber|category     |
    |0            |"Nowości"    |
    |2            |"Nowości"    |
    |3            |"Nowości"    |
    |0            |"Bestsellery"|
    |2            |"Bestsellery"|


  Scenario Outline: I test using the "kwotowy300" coupon code when a value of the shopping cart is less than 3000 zł
    Given The product number <productNumber> from the <category> category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Minimalna wartość zamówienia dla tego kuponu to 3 000,00 zł." error message has been displayed

    Examples:
    |productNumber|category     |
    |1            |"Nowości"    |
    |1            |"W promocji" |
    |2            |"W promocji" |
    |1            |"Bestsellery"|


  Scenario Outline: I test using "windsurfing350" coupon code for a product from the windsurfing category
    Given The product number <productNumber> from the <category> category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "windsurfing350" as a coupon code 
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed

    Examples:
    |productNumber|category |
    |0            |"Nowości"|
    |2            |"Nowości"|
    |3            |"Nowości"|


  Scenario Outline: I test using "windsurfing350" coupon code for a product from the non-windsurfing category
    Given The product number <productNumber> from the <category> category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "windsurfing350" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Przepraszamy, tego kuponu nie można zastosować do wybranych produktów." error message has been displayed

    Examples:
    |productNumber|category     |
    |1            |"Popularne"  |
    |3            |"W promocji" |
    |1            |"Bestsellery"|


  Scenario Outline: I test reusing a redeemed coupon
    Given The product number 3 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    And Waits for 2 seconds
    And Clicks on the coupon code field
    And Enters the <couponCode> as a coupon code again
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został zastosowany!" error message has been displayed

    Examples:
    |couponCode             |
    |"kwotowy250"           |
    |"10procent"            |
    |"kwotowy300"           |
    |"kwotowy300bezpromocji"|
    |"10procent1"           |
    |"windsurfing350"       |


  Scenario Outline: I test Aan attemption to link coupon "kwotowy250pojedynczy" to other coupons
  Given The product number 0 from the "Popularne" category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy250pojedynczy" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    And Waits for 2 seconds
    And Clicks on the coupon code field
    And Enters the <couponCode> as a coupon code again
    And Clicks the 'Zastosuj kupon' button
    Then The "Przepraszamy, kupon \"kwotowy250pojedynczy\" został już użyty nie może być powiązany z innymi kuponami." error message has been displayed

    Examples:
    |couponCode             |
    |"kwotowy250"           |
    |"10procent"            |
    |"kwotowy300"           |
    |"kwotowy300bezpromocji"|
    |"10procent1"           |
    |"windsurfing350"       |


  Scenario Outline: I test using an incorrect coupon code
    Given The product number 2 from the "W promocji" category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The <message> error message has been displayed

    Examples:
    |couponCode     |message                                |
    |"my_coupon123" |"Kupon \"myCoupon123\" nie istnieje!"  |
    |"code_094"     |"Kupon \"code_094\" nie istnieje!"     |
    |"blablacoupon" |"Kupon \"blablacoupon\" nie istnieje!" |
    |"bad_coupon^5%"|"Kupon \"bad_coupon^5%\" nie istnieje!"|


  Scenario: Blank coupon code field
    Given The product number 3 from the "Bestsellery" category has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Clicks the 'Zastosuj kupon' button leaving the coupon code field blank
    Then The "Proszę wpisać kod kuponu." error message has been displayed