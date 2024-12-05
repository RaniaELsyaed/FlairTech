Feature: Manage users in OrangeHRM

  Scenario: Add and delete a user
    Given the user navigates to the OrangeHRM login page
    When the user logs in with valid credentials
    And the user navigates to the Admin tab
    Then the user gets the number of records
    When the user adds a new user
    Then the number of records should increase by 1
    When the user deletes the new user
    Then the number of records should decrease by 1
