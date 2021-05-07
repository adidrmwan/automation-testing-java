@Web @Bukalapak @Login
Feature: User be able to login

  Background:
    Given user open bukalapak homepage

  @Invalid-Password
  Scenario: User be able to see error message when input invalid password
    When user click login button
    Then user on login page
    When user input email
    And user input invalid password
    And user click login button on login page
    Then user see error message invalid email or password