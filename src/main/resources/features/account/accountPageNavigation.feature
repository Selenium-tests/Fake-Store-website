@BillingLinks
Feature: Account page links

  Background:
    Given The user is logged in with email: "my_email@gmail.com" and password: "secret_password"

  @APNLinks
  Scenario Outline: Links on the account page
    When The user clicks the <link> link
    Then The page with url <url> has been opened

    Examples:
    |link             |url                                                     |
    |"Kokpit"         |"https://fakestore.testelka.pl/moje-konto/"             |
    |"Moje zamówienia"|"https://fakestore.testelka.pl/moje-konto/zamowienia/"  |
    |"Edycja konta"   |"https://fakestore.testelka.pl/moje-konto/edytuj-konto/"|
    |"Adres"          |"https://fakestore.testelka.pl/moje-konto/edytuj-adres/"|

  @APNLogout
  Scenario: Logout
    When The user clicks the "Wyloguj" link
    Then The user is logged out
