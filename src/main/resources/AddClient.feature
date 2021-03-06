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
    Given the name "Mathias"
    And the email "mathias@gmail.com"
    And the password "password"
    And the reference person "Nima"
    And the address "123 Street"
    And a logistic company
    When add client
    Then the new client is added to the company
 
 Scenario: Client with email already exists
   Given the name "Mathias"
   And the email "mathias@gmail.com"
   And the password "password"
   And the reference person "Nima"
   And the address "123 Street"
   And a logistic company containing client with email "mathias@gmail.com"
   When add client
   Then client is not added to the company