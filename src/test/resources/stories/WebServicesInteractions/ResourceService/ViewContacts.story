Meta:

Narrative:
As a user
I want to have ability to see existing contacts
So that I can know what contacts we have

Scenario: Get contact by it's id
Given a system with some contacts
When I request contact with id is <id>
Then contact with id is <id> is returned
And contact has name <lastName> <firstName>
Examples:
|id|lastName|firstName|
|1|Doe|John|
|2|White|Alice|

Scenario: Get all contacts
Given a system with some contacts
When I request all contacts
Then the contacts returned are:
|id|lastName|firstName|
|1|Doe|John|
|2|White|Alice|
|3|Green|James|