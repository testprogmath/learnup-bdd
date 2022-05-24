Feature: Authorization
  I as user want to log in to the system

  Scenario Outline: Login as a standard user
    Given I open login page
    When I fill in login field with "<username>"
    And I fill in password field
    And I click Login button
    Then I am on Inventory page
    Examples:
      | username      |
      | standard_user |
      | problem_user  |


  Scenario Outline: Login as a locked_out_user
    Given I open login page
    When I fill in login field with "<username>"
    And I fill in password field
    And I click Login button
    Then I see an error message "<error_message>"
    Examples:
      | username        | error_message                                                             |
      | locked_out_user | Epic sadface: Sorry, this user has been locked out.                       |
      | wrong_username  | Epic sadface: Username and password do not match any user in this service |