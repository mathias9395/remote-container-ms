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
Feature: Updating journey

  @tag1
  Scenario: Journey information updated successfully
  	Given a journey
  	And an origin "Hamburg"
  	And a destination "San Diego"
    And a content type "Bananas"
    And a company "new company"
    When update journey
    Then journey contains updated information

  #@tag1
  #Scenario: Update containers current position
    #Given client "Client"
    #And A containers current position "position"
    #When Update  containers current position
    #Then Containers current position is updated
#
#
#	Scenario: Update containers origin
#	  Given client "Client"
    #And An origin "origin"
    #When Update origin
    #Then Origin is updated
#
#	Scenario: Update desitnation
 #		Given client "Client"
    #And A destination "destination"
    #When Update destination
    #Then Destination is updated