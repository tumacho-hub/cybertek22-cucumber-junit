Feature: Adidas Order Placement Functionalities
  Agile Story: As a User, I should be able to place order from the Website

  Background: Go to home page
    Given User is on the home page


  Scenario: Placing a successful order
    When  User adds "Sony vaio i5" from "Laptops"
    And   User adds "Dell i7 8gb" from "Laptops"
    And   User adds "Apple monitor 24" from "Monitors"
    And   User removes "Sony vaio i5" from cart
    And   User place order and capture logs purchase ID and Amount
    Then  User verifies purchase amount equals expected

  @wip
    Scenario: Verify all the products exists in the categories
    Then      Under "Phones" category user should see the list of products
        | Samsung galaxy s6  |
        | Nokia lumia 1520   |
        | Nexus 6            |
        | Samsung galaxy s7  |
        | Iphone 6 32gb      |
        | Sony xperia z5     |
        | HTC One M9         |
    And       Under "Laptops" category user should see the list of products
        | Sony vaio i5          |
        | Sony vaio i7          |
        | MacBook air           |
        | Dell i7 8gb           |
        | 2017 Dell 15.6 Inch   |
        | MacBook Pro           |
     And      Under "Monitors" category user should see the list of products
        | Apple monitor 24  |
        | ASUS Full HD      |

    @wip
    Scenario Outline: verify each product's displayed price is same with cart price
        When  User adds "<addedProducts>" from "Phones" tp see price
        And   User removes "<removeProducts>" from cart to verify the price
        Then  User verifies list and cart price are same and they are equal to "<expectedPrice>"

      Examples: Products from the website and their expected price
        | addedProducts     | removeProducts     | expectedPrice    |
        | Samsung galaxy s6 | Samsung galaxy s6  | 360              |
        | Nokia lumia 1520  | Nokia lumia 1520   | 820              |
        | Nexus 6           | Nexus 6            | 650              |
        | Samsung galaxy s7 | Samsung galaxy s7  | 800              |
        | Iphone 6 32gb     | Iphone 6 32gb      | 790              |
        | Sony xperia z5    | Sony xperia z5     | 320              |
        | HTC One M9        | HTC One M9         | 700              |



