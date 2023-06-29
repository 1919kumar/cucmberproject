Feature: Search functionality

Background:
Given User open the Application

Scenario: Search for a valid product
When User enters Valid product "hp" into search field
And User clicks on Search button
Then Valid product should get displayed in search results

Scenario: Search for a non-existing product
When User enter non-existing product "honda" into search field
And User clicks on Search button
Then Proper text informing the user about no product matching should be displayed

Scenario: Search without providing any product
When User dont enter any product into search field
And User clicks on Search button
Then Proper text informing the user about no product matching should be displayed
