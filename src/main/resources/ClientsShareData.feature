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
Feature: Displaying a client's data to other selected client

  @tag1
  Scenario: Data successfully shared with another client
    Given a client 
    And a client2 that is in logistic company 
    When client2 exists
    Then show client2 the information of client1
    
  Scenario: Data not shared with another client
    Given a client 
    And a client2 that is not in logistic company
    When client2 does not exist
    Then do not show client2 the information of client1