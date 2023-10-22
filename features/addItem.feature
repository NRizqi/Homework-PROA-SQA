Feature: add Item

  @addItemPositive
  Scenario: user want to add item to cart
    Given user already login
    When user in homepage screen
    And user click add to cart button for any item
    And button change to remove button
    And cart icon have count number
    Then item succesfully added to cart

  @addItemNegative
  Scenario: user cant add item to cart from item page
    Given user already login
    When user tap any item
    And user directed to item page
    And user click add to cart button
    And button didnt change into remove button
    And cart icon didnt show count number
    Then user cant add item to cart from item page

