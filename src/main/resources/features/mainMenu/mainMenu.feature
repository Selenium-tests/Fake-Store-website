Feature: Main menu

  Background:
    Given The page with url "https://fakestore.testelka.pl/" is open

  Scenario Outline: Main menu links
    When The user clicks the <link> link
    Then The page with url <url> has been opened
    Examples:
    |link           |url                                         |
    |"Sklep"        |"https://fakestore.testelka.pl/shop/"       |
    |"Zamówienie"   |"https://fakestore.testelka.pl/zamowienie/" |
    |"Koszyk"       |"https://fakestore.testelka.pl/koszyk/"     |
    |"Moje konto"   |"https://fakestore.testelka.pl/moje-konto/" |
    |"Lista życzeń" |"https://fakestore.testelka.pl/wishlist"    |
    |"Strona główna"|"https://fakestore.testelka.pl/"            |
