Meta:
@api
@issue ST-09

Narrative:
As a frontend user
I want to send different requests to server
So that I can use different clients to perform server communications

Scenario: sending POST requests to HTTP service
When I send to HTTPService request with <parameter1> and <parameter2> and <data>
Then response contains <parameter1>, <parameter2> and <data>
Examples:
|parameter1|parameter2|data
|aaaaa|bbbbb|custom data pampampam|
|first param|second param|this is data|


Scenario: sending PUT requests to HTTP service
When I send to HTTPService PUT request with <parameter1> and <parameter2> and <data>
Then response contains <parameter1>, <parameter2> and <data>
Examples:
|parameter1|parameter2|data
|zzzzzz|xxxxx|custom put data pampampam|
|third param|fourth param|this is put data|