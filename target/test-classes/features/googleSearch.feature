Feature: Google search functionality
  Agile Story: As a user, when I am on the google search page,
  i should be able to search whatever i want, and see relevant
  information
  Scenario: Search page title verification
    Given User is on Google home page
    Then User should see title is google


  Scenario: User search title verification
    Given User is on Google home page
    When User searches for apple
    Then User should see apple in the tittle
@google
  Scenario: User search title verification
    Given User is on Google home page
    When User searches for "wooden spoon"
    Then User should see "wooden spoon" in the tittle