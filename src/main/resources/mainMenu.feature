Feature: Main menu

  Scenario Outline: I test the main menu
    Given The user is on the home page
    When The user clicks <link> link
    Then The page with url <url> has been opened
    Examples:
    |link           |url                                         |
    |"Sklep"        |"https://fakestore.testelka.pl/shop/"       |
    |"Zamówienie"   |"https://fakestore.testelka.pl/zamowienie/" |
    |"Koszyk"       |"https://fakestore.testelka.pl/koszyk/"     |
    |"Moje konto"   |"https://fakestore.testelka.pl/moje-konto/" |
    |"Lista życzeń"  |"https://fakestore.testelka.pl/lista-zyczen"|
    |"Strona główna"|"https://fakestore.testelka.pl/"            |
