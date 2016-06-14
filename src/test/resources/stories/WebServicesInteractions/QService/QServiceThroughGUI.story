Meta:

Narrative:
As a tester
I want to perform an action on GUI elements related to QService
So that I can make sure that all delays and timeouts are handled correctly

Scenario: scenario description
Given QService mapped page is open
When I execute <action> related to <serviceType> service
Then the output <result> is displayed
Examples:
|action|result|serviceType|
|Success|Call1 GET request successful, Call2 GET request successful, Call3 GET request successful|http|
|Failure|404|http|
|Success|"Already resolved promise","Call 1 said: successful execution!","Call 2 said: successful execution!"|fake|
|Failure|Call 2 said: function failure!|fake|