
Feature: Login feature

  Background:
    Given Navigate to website

  Scenario: Login Scenario
    Given User should login with a valid username and password
    Then  Verify that user could login successfully