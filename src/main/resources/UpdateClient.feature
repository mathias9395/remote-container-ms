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
  Scenario: Update reference person
		Given a client "Client"
		And a reference person "Mathias"
		When update reference person
		Then refrence person is updated
		
	Scenario: Update email
		Given a client 
		And an email "Mathias@gmail.com"
		When update email
		Then email is updated
  #Scenario: update info for client successful
  #	Given an email "mathias@gmail.com" with name "Mathias"
  #	And company set containing client
  #	When update client information
  #	Then client updated with new information
  #Scenario: client not found
  #	Given an email "mathias@gmail.com" with name "Mathias"
  #	And company set not containing client
  #	When update client information
  #	Then client not in list message
 
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
  	
  	

