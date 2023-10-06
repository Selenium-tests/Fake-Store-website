Feature: Account page links

  Background: An user is logged in
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"

  Scenario Outline: I test links on the account page
    When An user clicks the <link> link
    Then The page with url <url> has been opened

    Examples:
    |link             |url                                                     |
    |"Kokpit"         |"https://fakestore.testelka.pl/moje-konto/"             |
    |"Moje zamówienia"|"https://fakestore.testelka.pl/moje-konto/zamowienia/"  |
    |"Edycja konta"   |"https://fakestore.testelka.pl/moje-konto/edytuj-konto/"|
    |"Adres"          |"https://fakestore.testelka.pl/moje-konto/edytuj-adres/"|


  Scenario: I test the logout feature
    When An user clicks the "Wyloguj" link
    Then An user is logged out
