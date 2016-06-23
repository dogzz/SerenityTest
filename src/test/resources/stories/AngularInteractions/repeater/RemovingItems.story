Meta:
@tag feature: repeater
@web
@issue ST-06

Narrative:
As a user
I want to remove items
So that I can manipulate with items count

Scenario: remove one not last item
Given repeater is open
And two item are added
When I removing one item
Then removed item is not displayed
And second item is still displayed

Scenario: remove last item
Given repeater is open
And one item is added
When I removing one item
Then removed item is not displayed
And table is not displayed