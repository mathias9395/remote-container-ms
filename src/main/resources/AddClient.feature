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
Feature: Adding a new client

  @tag1
  Scenario: Add client successful
    Given a name "Mathias"
    And a email "mathias@gmail.com"
    And a password "password"
    And a reference person "Nima"
    And an address "123 Street"
    When add client
    Then client list has new client
    
  Scenario: Client already exists
    Given a name "Mathias"
    And a email "mathias@gmail.com"
    And a password "password"
    And a reference person "Nima"
    And an address "123 Street"
    When add client
    Then client list contains client
   