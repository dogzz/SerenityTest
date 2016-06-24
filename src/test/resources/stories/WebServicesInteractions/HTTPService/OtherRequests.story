Meta:
@api
@issue ST-08

Narrative:
As a frontend user
I want to send Delete and Head requests to server
So that I can use different clients to perform server communications

Scenario: sending DELETE requests to HTTP service
When I send to HTTPService DELETE request with <parameter1Value> and <parameter2Value>
Then response contains <parameter1Name> with value <parameter1Value>
And response contains <parameter2Name> with value <parameter2Value>
Examples:
|parameter1Value|parameter2Value|parameter1Name|parameter2Name|
|zzzzzzDelete|xxxxxDelete|param1|param2|
|third param Delete|fourth param Delete|param1|param2|

Scenario: sending HEAD requests to HTTP service
When I send to HTTPService HEAD request with <parameter1Value> and <parameter2Value>
Then response is successful
Examples:
|parameter1Value|parameter2Value|
|zzzzzz Head|xxxxx Head|
|third param Head|fourth param Head|