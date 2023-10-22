Feature: credential filling

  @credential
  Scenario: user fill credential need
    Given user in cart page
    When user click checkout
    And user directed to checkout your information page
    And user fill first name
    And user fill last name
    And user fill postal code
    And user click continue
    Then user directed to checkout overview page