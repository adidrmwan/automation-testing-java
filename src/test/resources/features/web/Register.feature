@Web @Bukalapak @Register
Feature: New User be able to register

  Background:
    Given user open bukalapak homepage

  @Invalid-Email
  Scenario: New user be able to see error message invalid email
    When user click register button
    Then user on register page
    When user input invalid email
    And user click register button on register page
    Then user see error message email or phone not suitable