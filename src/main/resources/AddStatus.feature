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
  Scenario: Successfully added container status
    Given a container
    And a temperature between zero and five thousand eight hundred kelvin 6.0
    And a pressure between zero and one thousand eighty hPa 9.0 
    And a humidity between zero and one hundred % 9.0 
    And a location "London"
    When add new status to container
    Then container contains updated information
    
  @tag2
  Scenario: Container not added (boundaries violated)
    Given a container1
    And a temperature not between zero and five thousand eight hundred kelvin 5900.0
    And /or a pressure not between zero and one thousand eighty hPa 1100.0
    And /or a humidity not between zero and one hundred % 200.0
    And a location "London"
    When add new status1 to container1
    Then container1 is not updated

 
 
