Feature: Wikipedia search functionality
  As a user, I should be able to search terms and see relevant information
  Case: Search for "Steve Jobs", the title, the header, and the image header should be displayed as "Steve Jobs"


Scenario: Wikipedia Search Functionality Title Verification
  Given User is on Wikipedia home page
  When  User types "Barack Obama" in the wiki search box
  And   User clicks wiki search button
  Then  User sees "Barack Obama" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification
    Given  User is on Wikipedia home page
    When  User types "Steve Jobs" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "Steve Jobs" is in the main header

#Example of scenario outline below
  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When  User types "<searchValue>" in the wiki search box
    And   User clicks wiki search button
    Then  User sees "<expectedMainHeader>" is in the wiki title
    Then  User sees "<expectedTitle>" is in the wiki title

    Examples: search terms we are going to use in this templates is as below
      | searchValue      | expectedMainHeader | expectedTitle    |
      | Steve Jobs       | Steve Jobs         | Steve Jobs       |
      | Albert Einstein  | Albert Einstein    | Albert Einstein  |
      | Nikola Tesla     | Nikola Tesla       | Nikola Tesla     |
      | Conor McGregor   | Conor McGregor     | Conor McGregor   |
      | Chuck Norris     | Chuck Norris       | Chuck Norris     |
      | Marie Curie      | Marie Curie        | Marie Curie      |
      | Natalie Dormer   | Natalie Dormer     | Natalie Dormer   |
#      | Ibrahim Tatlises | Ibrahim Tatlises   | Ibrahim Tatlises |
