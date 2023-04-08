Feature: Library app login feature
   User Story:
  As a user, I should be able to login with correct credentials to different accounts.
  and dashboard should be displayed.
  Accounts are: librarian, student, admin

Background: Assuming user is on the login page
  Given user is on the login page


@Librarian
Scenario: Login as librarian
  When  user enters librarian username
  And   user enter librarian password
  Then  user should see the dashboard

@Student
Scenario: Login as student
    When user enters student username
    And user enters student password
    Then user should see the dashboard

@Admin
  Scenario: Login as student
    When user enters admin username
    And user enters admin password
    Then user should see the dashboard