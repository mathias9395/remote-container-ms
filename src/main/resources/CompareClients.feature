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
  Scenario: Two clients are equal
    Given a client with the email "mathias@gmail.com" and the ID 7
    And another client with the email "mathias@gmail.com" and the ID 7
    When I check if they are equal
    Then the equality is true
    
  Scenario: Two clients are not equal
    Given a client with the email "mathias@gmail.com" and the ID 7
    And another client with the email "nima@gmail.com" and the ID 8
    When I check if they are equal
    Then the equality is not true