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
Feature: Find an existing journey

  @tag1
  Scenario: Journey search by content
    Given a journey with content "Bananas"
    And a client containing journey
    When search by content "Bananas"
    Then filtered journey list that contains content "bananas"
    
 Scenario: Journey search by origin
    Given a journey with origin "Copenhagen"
    And a client containing journey
    When search by origin "Copenhagen"
    Then filtered journey list that contains origin "Copenhagen"

    
    
    
    
    