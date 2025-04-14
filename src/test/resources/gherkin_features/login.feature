Feature: User Login

  Scenario: User logs in using valid credentials
    Given the user is on the home page
    When the user navigates to the login page
    And the user logs in with valid credentials
    Then the user should be logged in successfully
    And the user should be redirected to the homepage