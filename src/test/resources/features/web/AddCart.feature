@Web @Bukalapak @Cart
Feature: User be able to add product to cart

  Background:
    Given user open bukalapak homepage

  @No-Login
  Scenario: user must login before add product to cart
    When user input existing product "Monitor LED LG 24MP59G - 24 Inch"
    And user select existing product "Monitor LED LG 24MP59G - 24 Inch"
    Then user on product page
    When user click add to cart button
    Then user on login page