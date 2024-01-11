Feature: Adding a product from a product thumbnail
  
  Background: 
    Given The page with url "https://fakestore.testelka.pl/" is open

    @APTButtonVisibility
    Scenario: Visibility of the "Zobacz koszyk" button
      When The user clicks the "Dodaj do koszyka" button of the "Windsurfing w Lanzarote (Costa Teguise)" product thumbnail
      Then The "Zobacz koszyk" button is visible

    @APTClickingButton
    Scenario: Clicking the "Zobacz koszyk" button
      When The user clicks the "Dodaj do koszyka" button of the "Windsurfing w Lanzarote (Costa Teguise)" product thumbnail
      And Clicks the "Zobacz koszyk" button
      Then The shopping cart has been opened

    @APTCCheckingShoppingCart
    Scenario: Checking the shopping cart content
      When The user clicks the "Dodaj do koszyka" button of the "Windsurfing w Lanzarote (Costa Teguise)" product thumbnail
      And Clicks the "Zobacz koszyk" button
      Then The shopping cart is not empty
      And Product name and price match

