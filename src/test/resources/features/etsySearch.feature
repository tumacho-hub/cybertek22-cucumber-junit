Feature: Etsy search feature


  Scenario: Etsy default title verification

    Given User is on the etsy landing page
    Then User should see Etsy title as expected

  #Etsy: - Shop for handmade, vintage, custom, and unique gifts for everyone


  Scenario: Etsy search functionality title verification
    Given User is on the etsy landing page
    When User types Wooden Spoon in the search bar
    And User clicks to search button
    Then User sees title is Wooden spoon | Etsy

