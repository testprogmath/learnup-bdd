#language: en
Feature: filling in the information about the user who orders the swag

  Background:
    Given I am authorized
    And I see an inventory page

  Scenario: Fill in user data positive
    When I add an item to the cart
    And I click the cart
    And I click checkout
    And I fill in "<firstName>"
    And I fill in "<secondName>"
    And I fill in "<ZIPcode>"
    And I click Continue button
    Then I see checkout overview page

  Example:
  |firstName    |secondName            |ZIPcode|
  |Anna         | Kh                   |1018VN |
  |Vasiliy      | Lopukhov-Kalachensky |188660 |

  Scenario: Fill in user data negative
    When I add an item to the cart
    And I click the cart
    And I click checkout
    And I fill in "<username>"
    And I fill in "<password>"
    And I fill in "<ZIP code>"
    And I click Continue button
    Then I see error message