Meta:
@api

Narrative:
As a user
I want to have ability to add, update and remove contacts
So that I can manage list of contacts in the system

Scenario: Add new contact
Given a system with some contacts
When I add new contact
Then response with user parameters is returned

Scenario: Delete existing contact
Given a system with some contacts
When I delete existing contact
Then response about successful removal is returned
And contact is not present in the system

Scenario: Update existing contact
Given a system with some contacts
When I update data for existing contact
Then response about successful update is returned