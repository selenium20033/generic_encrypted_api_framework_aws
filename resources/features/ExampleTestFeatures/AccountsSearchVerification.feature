#Author: mozkan@thinkwhy.com

Feature: Accounts Search Verification

  Background: 
    Given I login to Example Platform
    And I click on Accounts Module
    And I click on Accounts List Button
  @accountsSearch
  Scenario Outline: Searching Accounts From Table by Name
    
   When I enter "<name>" to the search box on the top
   Then I see the "<name>" on the table
   
    Examples: 
    |name                |
    |Foo                   |
    @smoke
    Scenario Outline: Searching by invalid data
    
    When I enter invalid "<data>" to search box on the top
    Then I see the no data info on the table
   
    Examples: 
    |data                |
    |invalid           |
      
