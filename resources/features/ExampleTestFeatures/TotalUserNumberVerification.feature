#Author: mozkan@thinkwhy.com

Feature: Total user number verification

  Background: 
    Given I login to Example Platform
    And I click on Accounts Module
    And I click on Accounts List Button
    
    @totalVerify
Scenario: Total user number verification
    
   When I get the number of users from all users column header
   And I get the number of users from subscribed users column header
   And I get the number of users from transactional users column header
   And  I get the number of users from suspended users column header
   And  I get the number of users from pending activation users column header
   And  I get the number of users from pending payment users column header
   And  I get the number of users from inactive users column header
   Then  I verify that sum of the column users is equal to all users header
  
  
   
   
    