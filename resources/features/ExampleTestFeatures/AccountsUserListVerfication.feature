#Author: mozkan@thinkwhy.com
 
Feature: Accounts User Number Validation
Background:
Given I login to Example Platform
And I click on Accounts Module
And I click on Accounts List Button

  @validate
 Scenario: Validating Account User Number
    
   And I click on All link
   Then I validate the number of the users on the table
  
       