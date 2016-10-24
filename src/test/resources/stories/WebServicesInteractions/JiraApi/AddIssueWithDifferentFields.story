Meta:
@api
@issue ST-07
@jiratest

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: add issue with correct fields
Given a jira user logged in using basic authentication
When the user add issue with fields <summary>, <type>, <description>, and <project>
Then the issue added succesfully
And the issue can be viewed in list of issues with correct <summary>, <type>, <description>, and <project>

Examples:
|summary|type|description|project|
|summary1|Task|description 1|TST|
|summary2|Task|description 2|TST|


Scenario: add issue with incorrect fields
Given a system with some issues
When the user add issue with fields <summary>, <type>, <description>, and <project>
Then the error message is received with mention of <error>

Examples:
|summary|type|description|project|error|
||Task|description 1|TST|summary|
|summary2|Task|description 2|NONE|project|
|summary3|NONE|description 3|TST|type|