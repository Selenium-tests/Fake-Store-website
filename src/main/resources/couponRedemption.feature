Feature: Coupon redemption

  Background: The product is the shopping cart
    Given The product has been added to the shopping cart
    And The shopping cart page is open
    When An user clicks on the coupon code field

  #Scenario Outline: Correct coupon code
    #And Enters the <couponCode> as a coupon code
    #And Clicks the 'Zastosuj kupon' button
    #Then The <message> message has been displayed

    #Examples:
    #|couponCode|message|
    #|"kwotowy250"|"Kupon został pomyślnie użyty."|


  Scenario Outline: Reusing a redeemed coupon
    And Enters the <couponCode> as a coupon code
    And Clicks the 'Zastosuj kupon' button
    And Waits for 2 seconds
    And Clicks on the coupon code field
    And Enters the <couponCode> as a coupon code again
    And Clicks the 'Zastosuj kupon' button
    Then The <message> error message has been displayed

    Examples:
    |couponCode|message|
    |"10procent"|"Kupon został zastosowany!"|