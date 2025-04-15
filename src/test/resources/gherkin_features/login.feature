Feature: User Login

  Scenario: User logs in using valid credentials
    Given the user is on the home page
    When the user navigates to the Sign in page
    And the user logs in with valid data
    Then the user should be redirected to the homepage