Feature: Account Summary Activity

  Background:
    Given User is on the login page
    And User logins with "username" and password "password"


    Scenario: Checking the account summary page features
      And  The "Account Summary" page should be displayed
      Then Account Summary page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table must have these columns
      | Account     |
      | Credit Card |
      | Balance     |