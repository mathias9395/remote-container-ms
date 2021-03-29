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
Feature: Title of your feature (yuh yuh!)
  I want to use this template for my future life

  @tag1
  Scenario: Journey added successfully
    Given An origin
    And A destination
    And A content type
    And A company
    And A password
    When I add the journey
    Then New journey is added to the list of journeys
    And Tell user that the journey has been added

	Scenario: pogger :)
		Given an origin
		And A destinatiom
		And A content type
		And A company
		And A password
		When I add the journey
		Then Journey list already contains journey
		And Tell user that the journey already exists
	

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
