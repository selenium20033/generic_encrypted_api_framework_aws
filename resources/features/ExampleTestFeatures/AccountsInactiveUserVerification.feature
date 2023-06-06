#Author: mozkan@thinkwhy.com
  
Feature: Inactive user verification
@smoke
 Scenario: Validating Inactive Users
 Given I login to Example Platform
 When I click on Accounts Module
 And I click on Accounts List Button
 And I click on Inactive Button Button
 Then I verify that the status of the user is as inactive on the table