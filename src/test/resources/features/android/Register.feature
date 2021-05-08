@Android @Register
Feature: User be able to register

  Background:
    Given android user on landing screen

  @Negative
  Scenario: Android user be able to see error message when input invalid email
    When android user tap register link
    Then android user on register screen
    When android user input name
    And android user input invalid email
    And android user input password
    And android user input confirmation password
    And android user tap register button
    Then android user see error message invalid email
