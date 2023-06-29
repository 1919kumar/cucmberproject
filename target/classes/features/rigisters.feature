Feature: User registration

Background:
Given user navigate to Register page

Scenario: Register with Mandatory fields
When User enter below details into the fields
|firstname				|Rahul|
|lastname					|Ravindhra|
|emailaddress			|saikumar6@gmail.com|
|telephone				|135435237|
|password					|12345|
|confirmpassword	|12345|
And Select Privacy policy field
And Click on Continue button
Then Account should get sucessfully created

Scenario: Register with All fields
When User enter below details into the fields
|firstname				|kamesh|
|lastname					|Rao|
|emailaddress			|saikumar7@gmail.com|
|telephone				|135435237|
|password					|12345|
|confirmpassword	|12345|
And Select yes for News letter
And Select Privacy policy field
And Click on Continue button
Then Account should get sucessfully created

Scenario: Register without providing any fields
When User dont enter details into any field
And Click on Continue button
Then Warning message should be displayed for all the mandatory field

Scenario: Register with duplicate email address
When User enter below details into the fields
|firstname				|Raja|
|lastname					|rao|
|emailaddress			|saikumar1919123@gmail.com|
|telephone				|135435437|
|password					|78521444|
|confirmpassword	|78521444|
And Select yes for News letter
And Select Privacy policy field
And Click on Continue button
Then waning message informating the user about duplicate email should be displayed
