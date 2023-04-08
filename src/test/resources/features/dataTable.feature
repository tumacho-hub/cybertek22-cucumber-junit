Feature: Examples os Cucumber data implementations

 # TC#28: PracticeCybertek/dropdowns month dropdown options verification
  #http://practice.cybertekschool.com/dropdown


  Scenario: User should be able to see all 12 months in months
  dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January  |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |









  Scenario: Something happens
    # Given user does something
    # to get the pipes line up we can use the following short cuts
    # MAC command + optional + l
    # Windows control + alt + l


  Then user should see below words displayed
    | Apple      |
    | Kiwi       |
    | Orange     |
    | Strawberry |
    | Mango      |
    | Tomato     |
    | Cucumber   |


    Scenario: Library login example using data table
      Given user is on the login page library app
      When  user enter username and password as below
        | username | librarian13@library |
        | password | 9rf6axdD            |
      Then  user should see title is Library