Feature: Amazon Search and cart feature

  @wip
  Scenario: Amazon search and cart functionality
    Given User is on Amazon Home Page
    When  User search for hats for man
    And   User adds the first  hat appearing to the cart with quantity two
    Then  The total price and quantity should be correct
    When  User reduce the quantity from two to one
    Then  Total price and quantity has been correctly changed