Feature: Etsy search feature


  Scenario: Etsy default title verification
    Given   user is on the etsy landing page
    Then    user should see etsy title as expected


  Scenario: Etsy Search Functionality Title Verification
    Given user is on the etsy landing page
    When  user types Wooden Spoon in the search bar
    And   user clicks to search button
    Then  user sees title Wooden spoon | Etsy


