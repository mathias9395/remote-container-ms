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
Feature: Add container status

  @tag1
  Scenario: New journeys are found
    Given a client that has at least one journey
    When there are existing new journeys
    And the the user chooses to search for a new journey
    Then new journeys are found and located in the new journey set
   
  Scenario: No new journeys are found
    Given a client that has at least one journey
    When there are no existing new journeys
    And the the user chooses to search for a new journey
    Then the new journey set is empty and no new journeys are found
  
   

 
 
