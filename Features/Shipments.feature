Feature: Shipments

  Scenario: Successful Login with valid credentials
    Given User Launch Chrome browser
    When User opens URL "https://opensky-bi.azurewebsites.net/login"
    And User enters User as "oskmad" and Password as "oskmad"
    And Click on Login
    Then Page Title should be "OpenSky"
    When CLick on Customer dropdown
    When User select "Fedex" on dropdown Customer
    And Click on Search button
    Then The column Customer on the grip should contain "Fedex" text
    And Close Browser
