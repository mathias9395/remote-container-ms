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
Feature: Updating Client
#
#
  @tag1
  #Scenario: Update refrence person
    #Given a refrence person "Nick"
    #When update client refrence person
    #Then display message that refrence person is updated
#
#
  #Scenario: Update email
    #Given a email "nick@gmail.com"
    #When update client email
    #Then display message that email is updated
    #
    #
  Scenario: update info for client successful
  	Given an email "mathias@gmail.com" with name "Mathias"
  	And a name "Mathias"
    And a phone number "60606060"
    And a password "password"
    And a email "new@gmail.com"
  	When update client information
  	Then display successfully updated
  #	
 #Scenario: update info for client successful
  #	Given a client "client"
  #	And list not containing a client
  #	And a name "Mathias"
    #And a phone number "60606060"
    #And a email "mathias@gmail.com"
    #And a password "password"
  #	When client is not found
  #	Then display message not updated
  	
  	

