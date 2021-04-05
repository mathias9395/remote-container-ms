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
Feature: Updating the temperature, humidity, atmospheric pressure of the container over time

  @tag1
  Scenario: Add container status entry
    Given a container with client with location "Copenhagen"
    And temperature 50.0
    And humidity 80.0
    And atmospheric pressure 50.0
    When add new status entry to container
    Then check if container contains new status
