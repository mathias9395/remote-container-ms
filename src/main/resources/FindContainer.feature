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
Feature: Find an existing container

  @tag1
  Scenario: Find container by ID
    Given a logistic company
    And a container with ID 10
    When the logistic company has the container
    Then the logistic company gets container with ID 10
    
  Scenario: Unsuccessful find container by ID
    Given a logistic company
    And a container with ID 10
    When the logistic company does not contain the container
    Then the logistic company does not get container with ID 10
    