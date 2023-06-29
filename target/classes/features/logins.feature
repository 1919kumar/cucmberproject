Feature: User Login 
Registered user should be able to login to access account details

Background:
Given User navigate to login page

Scenario Outline: Login with valid Credentials
When User enters valid email address <email>
And Enters valid password <password>
And clicks on Login button
Then User should Login Successfully
Examples:
|email		|password|
|saikumar1919123@gmail.com|12345|
|saikumar6@gmail.com|12345|
|saikumar1@gmail.com|12345|
|saikumar2@gmail.com|12345|

Scenario: Login with Invalid Credentials
When User enters invalid email address "saikumar@ealpha.in"
And Enter invalid password "Healph@12"
And clicks on Login button
Then User should get a proper warning message

Scenario: Login with valid email id and invalid password
When User enter valid email address "saikumar1919123@gmail.com"
And Enter invalid password "Healph@12"
And clicks on Login button
Then User should get a proper warning message

Scenario: Login with Invalid email id and valid password
When User enters invalid email address "saikur@healpha.in"
And Enter valid password "12345"
And clicks on Login button
Then User should get a proper warning message

Scenario: Login without providing any credentials
When User dont enter any credentials
And clicks on Login button
