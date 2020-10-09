@tests
 Feature: Search Expedia
   Scenario: Search Flights
     Given I open home page
     When I click tab "Flights"
     And I click flight option "One-way"
     And I enter "San Francisco" into field "Leaving from"
     And I enter "Taipei" into field "Going to"
     And I set "November" "29" into "Departing day"
     And I click search
     Then i see results contains "Taipei"

   Scenario: Search Cars
     Given I open home page
     When I click tab "Cars"
     And I click car option "Airport transportation"
     And I enter location for "San Francisco" into field "Airport"
     And I enter location for "Hyatt Regency" into field "Hotel name"
     And I set "November" "29" into field Flight arrival date
     And I select "7:00 am" for field Flight arrival time
     And I click search transportation
     Then i see car search results contains "Airport Transportation"

   Scenario: Search Cruises
       Given I open home page
       When I click tab "Cruises"
       And I select "Hawaii" from field Going to
       And I set "November" "20" into field "Departs as early as"
       And I set "December" "5" into field "Departs as late as"
       And I click search cruises
       Then i see cruises search results contains "Hawaii Cruise"





