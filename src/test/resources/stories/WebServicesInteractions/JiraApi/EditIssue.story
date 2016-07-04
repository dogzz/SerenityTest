Meta:
@api
@issue ST-07
@jiratest

Narrative:
As a user
I want to edit an issue
So that I can change issue according to new occurences

Scenario: Change Summary and Description
Given a system with issue
When user edits Summary and Description of the issue
Then edit operation completes succesfully
And changed Summary and Description can be viewed

Scenario: Change Issue Type
Given a system with issue
When user edits Type of the issue
Then edit operation completes succesfully
And changed Type can be viewed

Scenario: Change Issue Type to incorrect
Given a system with issue
When user edits Type of the issue to incorrect value
Then edit operation completes with error
And original Type can be viewed