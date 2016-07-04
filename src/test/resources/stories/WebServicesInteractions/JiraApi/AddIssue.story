Add Issue using different Authorization schemes

Meta:
@api
@issue ST-07
@jiratest

Narrative:
As a user
I want to add an issue
So that I can see it in list of issues

Scenario: add issue using basic authentication
Given a jira user logged in using basic authentication
When the user add issue
Then the issue added succesfully
And the issue can be viewed in list of issues

Scenario: add issue using cookies authentication
Given a jira user logged in using cookies authentication
When the user add issue
Then the issue added succesfully
And the issue can be viewed in list of issues

Scenario: add issue using OAuth authentication
Meta:
@skip
Given a jira user logged in using OAuth authentication
When the user add issue
Then the issue added succesfully
And the issue can be viewed in list of issues