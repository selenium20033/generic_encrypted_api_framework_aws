#Author: mozkan@thinkwhy.com

Feature: Creating Account

  Background: 
    Given I login to Example Platform
    And I click on Accounts Module
    And I click on Accounts List Button
  @createAccount
  Scenario Outline: Creating Account 
    
   When I click on create account link
   And I click on one user button
   And click on select focused button
   And I select metro one
   And I click on confirm selections button
   And I enter "<firstname>" and "<lastname>"
   And I select the country
   And I select individual account option
   And I enter "<bussinessEmail>" to create account text box
   And I click on create account button
   And I see account already exists message
   Then I click on confirm button
   
   
    Examples: 
    |firstname                |lastname                |bussinessEmail                  |
    |Mustafa                   |Ozkan                     |mozkan@buzzle.com       |
    
