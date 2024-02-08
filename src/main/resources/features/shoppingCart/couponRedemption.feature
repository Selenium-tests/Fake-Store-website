Feature: Coupon redemption

  @CC250Success
  Scenario: Using the kwotowy250 coupon code
    Given The product: "Wakacje z yogą w Kraju Kwitnącej Wiśni" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy250" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed
    And The "Kupon: kwotowy250" coupon is displayed on the shopping cart summary

  @CC250SingleSuccess
  Scenario: Using the "kwotowy250pojedynczy" coupon code
    Given The product: "Wakacje z yogą w Kraju Kwitnącej Wiśni" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy250pojedynczy" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed
    And The "Kupon: kwotowy250pojedynczy" coupon is displayed on the shopping cart summary

  @CC250SingleReusing
  Scenario Outline: Linking the "kwotowy250pojedynczy" coupon to other coupons
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy250pojedynczy" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    And Clicks on the coupon code field
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Przepraszamy, kupon \"kwotowy250pojedynczy\" został już użyty nie może być powiązany z innymi kuponami." message has been displayed

    Examples:
      |couponCode             |
      |"kwotowy250"           |
      |"10procent"            |
      |"10procent1"           |


  @CC300Success
  Scenario: Using the "kwotowy300" coupon code when value of the shopping cart is 3000 zł or greater
    Given The product: "Wakacje z yogą w Kraju Kwitnącej Wiśni" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed


  @CC300Fail
  Scenario: Using the "kwotowy300" coupon code when a value of the shopping cart is less than 3000 zł
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Minimalna wartość zamówienia dla tego kuponu to 3 000,00 zł." message has been displayed


  @CC300NoPromotionSuccess
  Scenario: Using the "kwotowy300bezpromocji" coupon code
    Given The product: "Windsurfing w Lanzarote (Costa Teguise)" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300bezpromocji" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed


  @CC300NoPromotionFail
  Scenario: Using the "kwotowy300bezpromocji" coupon code when the product is on promotion
    Given The product: "Wakacje z yogą w Kraju Kwitnącej Wiśni" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "kwotowy300bezpromocji" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Przepraszamy, ten kupon nie może być zastosowany do przecenionych produktów." message has been displayed


  @CC10Percent1
  Scenario: Using the "10procent1" coupon code when value of the shopping cart is 3000 zł or greater
    Given The product: "Wakacje z yogą w Kraju Kwitnącej Wiśni" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "10procent1" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed


  @CC10Percent1Reusing
  Scenario: Reusing the 10procent1 coupon code
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "10procent1" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    And Clicks on the coupon code field
    And Enters the "10procent1" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został zastosowany!" message has been displayed


  @CC300WindsurfingSuccess
  Scenario: Using the "windsurfing350" coupon code for a product from the windsurfing category
    Given The product: "Windsurfing w Lanzarote (Costa Teguise)" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "windsurfing350" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Kupon został pomyślnie użyty." message has been displayed


  @CC350WindsurfingFail
  Scenario: Using the "windsurfing350" coupon code for a product from the non-windsurfing category
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "windsurfing350" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Przepraszamy, tego kuponu nie można zastosować do wybranych produktów." message has been displayed


  @CCOld
  Scenario: Using the "starośćnieradość" coupon code
    Given The product: "Windsurfing w Lanzarote (Costa Teguise)" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the "starośćnieradość" as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The "Ten kupon stracił ważność." message has been displayed


  @CCIncorrectCode
  Scenario Outline: Using an incorrect coupon code
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    Then The <message> message has been displayed

    Examples:
    |couponCode     |message                                |
    |"my_coupon123" |"Kupon \"my_coupon123\" nie istnieje!"  |
    |"code_094"     |"Kupon \"code_094\" nie istnieje!"     |
    |"blablacoupon" |"Kupon \"blablacoupon\" nie istnieje!" |
    |"bad_coupon^5%"|"Kupon \"bad_coupon^5%\" nie istnieje!"|


  @CCBlankCCodeField
  Scenario: Blank coupon code field
    Given The product: "Yoga i pilates w Portugalii" is in the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field
    And Clicks the 'Zastosuj kupon' button leaving the coupon code field blank
    Then The "Proszę wpisać kod kuponu." message has been displayed