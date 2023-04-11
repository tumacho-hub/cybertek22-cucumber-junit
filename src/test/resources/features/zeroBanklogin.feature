Feature: Online Banking login Feature

  Background: User login
    Given User is on the login page


  Scenario: Authorized users should be able to login to the application
    And  User logins with "username" and password "password"
    Then The "Account Summary" page should be displayed


  Scenario: Unauthorized users should not be able to login
    When    User logins with "wrong" and password "wrong"
    Then    Error message "Login and/or password are wrong." should be displayed
    When    User logins with "" and password ""
    Then    Error message "Login and/or password are wrong." should be displayed