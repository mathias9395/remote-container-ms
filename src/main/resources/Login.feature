#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Successful login
    Given an email "mathias@gmail.com"
    And a password "password"
    And all user profiles containg a user with email "mathias@gmail.com" and password "password"
    When I login
    Then login was successful
   
  @tag2
  Scenario: No user with email
    Given an email "mathias@gmail.com"
    And a password "password"
    And all user profiles containg a user with email "nima@gmail.com" and password "password"
    When I login
    Then login was unsuccessful

  @tag3
  Scenario: Incorrect password
    Given an email "mathias@gmail.com"
    And a password "password"
    And all user profiles containg a user with email "mathias@gmail.com" and password "wrong"
    When I login
    Then login was unsuccessful