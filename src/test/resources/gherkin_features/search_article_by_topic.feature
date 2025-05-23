Feature: Search and view articles by topics

  Scenario: User searches for a newspaper article and views the full article
    Given the user is on the Newspapers.com homepage
    And the user clicks the "Topics" header link
    When the user enters "Titanic" in the search bar
    And the user clicks the Search button
    Then the search results should contain "RMS Titanic"

    When the user clicks on "RMS Titanic" from the results
    Then the article details page for "RMS Titanic" should be displayed

  Scenario: User searches for a newspaper article and views the full article
    Given the user is on the Newspapers.com homepage
    And the user clicks the "Topics" header link
    When the user enters "Roosevelt" in the search bar
    And the user clicks the Search button
    Then the search results should contain "Roosevelt"

    When the user clicks on "Roosevelt" from the results
    Then the article details page for "Roosevelt" should be displayed


