Feature: Google search functionality
  Agile Story: As a user, when I am on the google search page,
  i should be able to search whatever i want, and see relevant
  information

  Scenario: User search title verification
    Given User is on Google home page
    When User searches for apple
    Then User should see apple in the tittle
