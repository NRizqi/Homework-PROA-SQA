Feature: Login Page

  @regression @positive
  Scenario: Login Success
    Given user already at sauce demo login page
    When user input registered username
    And user input registered password
    And user click login button
    Then user login successfully

  @regression @negative
  Scenario: Login failed
    Given user already at sauce demo login page
    When user input unregistered username
    And user input registered password
    And user click login button
    Then user failed to login

  @regression @negative
  Scenario: Login failed
    Given user already at sauce demo login page
    When user input registered username
    And user input unregistered password
    And user click login button
    Then user failed to login

  @TDD
  Scenario Outline: user login to sauce demo
    Given user already at sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And user click login button
    Then User login is <status>

    Examples:
      |username       |password         |status   |
      |standard_user  |secret_sauce     |success  |
      |normal_user    |secret_sauce     |failed   |
      |standard_user  |secret_password  |failed   |