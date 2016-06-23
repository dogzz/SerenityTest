Meta:
@tag feature: repeater
@web
@issue ST-05

Narrative:
As a user
I want to add items
So that I can manipulate with items count

Scenario: add one item
Given repeater is open
When I adding item
Then new item is added

Scenario: add two items
Given repeater is open
And one item is added
When I adding item
Then new item is added with incremented name
