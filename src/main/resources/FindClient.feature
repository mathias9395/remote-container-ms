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
Feature: Find an existing client

  @tag1
  Scenario: Client search by name
    Given client with name "Mathias" with "email" with "reference person" with "password" with "address"
    And a client list with client
    When search by name "Mathias"
    Then filtered client list contains client
    
  Scenario: Client search by email
    Given client with name "name" with "mathias@gmail.com" with "reference person" with "password" with "address"
    And a client list with client
    When search by email "mathias@gmail.com"
    Then filtered client list contains client
    
    
    
    
    
    
    
    