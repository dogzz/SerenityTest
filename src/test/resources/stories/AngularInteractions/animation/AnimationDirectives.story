Meta:
@issue ST-01
Narrative:
As a tester
I want to perform an action with animation
So that I can make sure that this works fine

Scenario: Show square
Given an animation page is open
When I check <element> element
Then square for <element> should be displayed
Examples:
|element|
|EnterLeave|
|AddRemoveClass|
|CSSFrame|

Scenario: Hide square
Given an animation page is open
And <element> element is checked
When I uncheck <element> element
Then square for <element> should not be displayed
Examples:
|element|
|EnterLeave|
|AddRemoveClass|
|CSSFrame|

Scenario: Reverse array
Meta:
@manual
Given an animation page is open
When I reversing array
Then array should be reversed

Scenario: Reverse array back
Meta:
@pending
Given an animation page is open
And array is reversed
When I reversing array
Then array should be reversed back

Scenario: Reverse array three times
Meta:
@pending
Given an animation page is open
When I reversing array
Then array should be reversed