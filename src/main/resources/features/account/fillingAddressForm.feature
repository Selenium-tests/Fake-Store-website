Feature: Address forms

  Background:
    Given An user is logged in with email: "my_email@gmail.com" and password: "secret_password"
    And Goes to the "Adres rozliczeniowy" form

  @AFCorrectData
  Scenario: I test the billing address form using a correct data
    When An user clicks the country drop-down list arrow
    And Types "Polska" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types "44-403" as a postcode
    And Types "Węglikowo" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has been saved

  @AFIncorrectFName
  Scenario: I test the billing address form using an incorrect first name
    When An user clicks the country drop-down list arrow
    And Types "Polska" in the drop-down search field
    And Presses the ENTER key
    And Types "A_dam_?!" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types "44-403" as a postcode
    And Types "Węglikowo" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

  @AFIncorrectLName
  Scenario: I test the shipping address form using an incorrect last name
    When An user clicks the country drop-down list arrow
    And Types "Niemcy" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "+$Slodowy_09" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types "44-403" as a postcode
    And Types "Węglikowo" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

  @AFIncorrectAddress
  Scenario: I test the shipping address form using an incorrect address
    When An user clicks the country drop-down list arrow
    And Types "Polska" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "__Korniszowa&35b_>" as an address
    And Types "44-403" as a postcode
    And Types "Węglikowo" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

  @AFIncorrectPostcode
  Scenario Outline: I test the shipping address form using an incorrect postcode
    When An user clicks the country drop-down list arrow
    And Types "Polska" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types <postcode> as a postcode
    And Types "Węglikowo" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

    Examples:
    |postcode|
    |"&4-345"|
    |"4^-345"|
    |"44&345"|
    |"44-x45"|
    |"44-3+5"|
    |"44-34!"|

  @AFIncorrectCity
  Scenario: I test the shipping address form using an incorrect city
    When An user clicks the country drop-down list arrow
    And Types "Niemcy" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types "44-345" as a postcode
    And Types "+_)My_City" as a city
    And Types "455657453" as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

  @AFIncorrectPhone
  Scenario Outline: I test the shipping address form using an incorrect phone number
    When An user clicks the country drop-down list arrow
    And Types "Polska" in the drop-down search field
    And Presses the ENTER key
    And Types "Adam" as first name
    And Types "Słodowy" as last name
    And Types "MalArt" as a company
    And Types "ul. Korniszowa 35b" as an address
    And Types "44-345" as a postcode
    And Types "+_)My_City" as a city
    And Types <phoneNumber> as a phone number
    And Types "john_doe@gmail.com" as a email
    And Clicks the "Zapisz adres" key
    Then The data has not been saved

    Examples:
    |phoneNumber  |
    |"-44325453"  |
    |"1P3543456"  |
    |"12/435345"  |
    |"435[54643"  |
    |"4553;5434"  |
    |"76567V432"  |
    |"455434@43"  |
    |"4326545=3"  |
    |"45536576#"  |
    |"phoneNumber"|

