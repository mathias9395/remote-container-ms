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
Feature: Sending message

  @tag1
  Scenario: Send a message as a client 
    Given a client that wants to send a message
    And a meassage "Hello" to send
    When the message is sent as a client
    Then client sent message contains message
    
    Scenario: Send a message as a company
    Given a client for messaging
    And a message "Hello" to send
    When the message is sent to the client
    Then client recived message contains message
   

  

   