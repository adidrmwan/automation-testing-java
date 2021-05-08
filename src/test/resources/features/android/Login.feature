@Android @LoginAndroid
Feature: User be able to login

  Background:
    Given android user on landing screen

  @Negative @Unregistered-User
  Scenario: Android user see error message when login using unregistered user
    When android user input unregistered email
    And android user input password
    And android user tap login button
    Then android user see "Wrong Email or Password" message