Feature: Adidas Order Placement Functionalities
  Agile Story: As a User, I should be able to place order from the Website

  @wip
  Scenario: Placing a successful order
    Given User is on the home page
    When  User adds "Sony vaio i5" from "Laptops"
    And   User adds "Dell i7 8gb" from "Laptops"
    And   User removes "Sony vaio i5" from cart
    And   User place order and capture logs purchase ID and Amount
    Then  User verifies purchase amount equals expected


