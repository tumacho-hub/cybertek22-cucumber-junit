Feature: Pay Bills Functionality

  Background:
      Given User is on the login page
      And User logins with "username" and password "password"

  Scenario: Date Format
      When Learn Date and DateFormat


    Scenario: Pay Bills Successful payment
      And  The user navigates to "Pay Bills" menu
      Then The "Pay Bills" page should be displayed
      When user completes a successful Pay operation
      Then "The payment was successfully submitted." alert should be displayed

  @wip
  Scenario: Negative payment test
    And  The user navigates to "Pay Bills" menu
    Then The "Pay Bills" page should be displayed
    When User tries to make a payment without entering the amount or date
    Then "Please fill out this field." alert should be displayed