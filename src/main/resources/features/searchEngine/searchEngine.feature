Feature: Search engine

  Background:
    Given The page with url "https://fakestore.testelka.pl/" is open

  @SEPlaceholder
  Scenario: Disappearing the search engine placeholder
    When The user clicks on the search engine field
    Then The placeholder disappears

  @SECorrectPhrase
  Scenario Outline: I test searching products with a correct phrase
    When The user clicks on the search engine field
    And Enters the '<phrase>' phrase
    And Submits
    Then Products have been found
    And Product names contain the phrase <phrase>

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
    Then Products have not been found

    Examples:
    |phrase|
    |"My product"|
    |"$#%564asd" |
    |"[NULL]"    |
    |"KOFDEQWDSA"|