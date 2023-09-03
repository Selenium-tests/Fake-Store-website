Feature: Search engine

  Scenario: Disappearing the search engine placeholder
    Given The user is on the home page
    When The user clicks on the search engine field
    Then The placeholder disappears

  Scenario Outline: Searching products with a correct phrase
    Given The user is on the home page
    When The user clicks on the search engine field
    And Enters the '<phrase>' phrase
    And Presses the ENTER key
    Then The products count text is present
    And Products count text is 'Wyświetlanie wszystkich wyników: <number>'
    And The number of products is <number>

    Examples:
    |phrase           |number|
    |"Windsurfing"    |6     |
    |"Wspinaczka"     |3     |
    |"Yoga i pilates" |5     |
    |"Żeglarstwo"     |1     |

    Scenario Outline: Searching products with an incorrect phrase
      Given The user is on the home page
      When The user clicks on the search engine field
      And Enters the '<phrase>' phrase
      And Presses the ENTER key
      Then The products count text is not present

      Examples:
      |phrase|
      |"My product"|
      |"$#%564asd" |
      |"[NULL]"    |
      |"KOFDEQWDSA"|