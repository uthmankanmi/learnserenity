Narrative:
As a Springer user
I want to have a search section
So that I can filter between my books

Scenario: Search length maximum validation
Given I'm a <userType> user on the Springer page
When I try to search for an amount of characteres bigger than the allowed one
Then an error is displayed

Examples:
|userType|
|non registered|

Scenario: Performing valid searches
Given I'm a <userType> user on the Springer page
When I perform a <searchType> search
Then a <searchType> result is displayed

Examples:
|userType|searchType|
|registered|Specific|
|non registered|No results|
|registered|Empty|




