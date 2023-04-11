Feature: Account Activity functions

  Background:
    Given User is on the login page
    And User logins with "username" and password "password"


    Scenario: Account activity features
      And The user navigates to "Account Activity" menu
      Then The "Account Activity" page should be displayed
      And Account drop down should have "Savings" selected
      Then Account drop down should have the following options
        | Savings         |
        | Checking        |
        | Savings         |
        | Loan            |
        | Credit Card     |
        | Brokerage       |
        And Transaction table should have column names
        | Date            |
        | Description     |
        | Deposit         |
        | Withdrawal      |
