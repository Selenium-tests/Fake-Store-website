Feature: Search engine

  @SEPlaceholder
  Scenario: Disappearing the search engine placeholder
    When The user clicks on the search engine field
    Then The placeholder disappears

  @SECorrectPhrase
  Scenario Outline: I test searching products with a correct phrase
    When The user clicks on the search engine field
    And Enters the '<phrase>' phrase
    And Submits
    Then The products count text is present

    Examples:
    |phrase           |
    |"Windsurfing"    |
    |"Wspinaczka"     |
    |"Yoga i pilates" |
    |"Żeglarstwo"     |

  @SEIncorrectPhrase
  Scenario Outline: I test searching products with an incorrect phrase
    When The user clicks on the search engine field
    And Enters the '<phrase>' phrase
    And Submits
    Then The products count text is not present

    Examples:
    |phrase|
    |"My product"|
    |"$#%564asd" |
    |"[NULL]"    |
    |"KOFDEQWDSA"|