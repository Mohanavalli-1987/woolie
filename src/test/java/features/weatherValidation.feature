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

Feature: Weather API 
  I want to use this template for my feature file

  @test
Scenario Outline: As a choosey surfer
Given I like to surf in any of two beaches <postal_code> of Sydney
And I only like to surf on <Monday & Friday> in next 16 days
When I look up the the weather forecast for the next 16 days with POSTAL CODES
Then I check to if see the temperature is between <12°C and 30°C>
And I check wind speed to be between 3 and 9
And I check to see if UV index is <= 12
And I Pick best suitable spot out of top two spots based upon suitable weather forecast for the day

 Examples:
 |postal_code|
 |2140|
 |2145|
 |2050|
 |2000|
 |2100|
 |2300|
 |2167|
 |2198|
 |2154|
 |2144|
   
 
 
 
