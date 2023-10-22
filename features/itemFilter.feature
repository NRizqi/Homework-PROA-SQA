Feature: item filter

  @usingfilter
  Scenario: user can use item filter
    Given user login and on homepage
    When user click filter button
    And user choose one option
    Then user can filter item