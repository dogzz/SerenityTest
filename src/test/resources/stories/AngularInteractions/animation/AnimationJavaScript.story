Meta:
@issue ST-02
Narrative:
As a tester
I want to perform an action with JavaScript animation
So that I can make sure that this works fine

Scenario: Show square by JavaScript
Given a JavaScript animation page is open
When I check JSEnterLeave element
Then square for JSEnterLeave should be displayed

Scenario: Hide square by JavaScript
Given a JavaScript animation page is open
And JSEnterLeave element is checked
When I uncheck JSEnterLeave element
Then square for JSEnterLeave should not be displayed