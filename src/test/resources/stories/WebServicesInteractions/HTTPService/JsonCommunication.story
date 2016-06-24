Meta:
@api
@issue ST-07

Narrative:
As a user
I want to send requests
So that I can receive a response

Scenario: sending requests to JSON Serice
When I send <parameter1> and <parameter2> to JsonService
Then response contains <parameter1> and <parameter2>
Examples:
|parameter1|parameter2|
|aaaaa|bbbbb|
|first param|second param|