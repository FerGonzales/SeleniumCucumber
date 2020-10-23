Feature: Login

  Scenario: Successful Login with valid credentials
    Given User Launch FireFox browser
    When User opens URL "https://opensky-bi.azurewebsites.net/login"
    And User enters User as "oskmad" and Password as "oskmad"
    And Click on Login
    Then Page Title should be "OpenSky"
    When User click on Logout link
    Then Page Title should be "OpenSky"
    And Close Browser

  Scenario Outline: Login button Status
    Given User Launch FireFox browser
    When User opens URL "https://opensky-bi.azurewebsites.net/login"
    And User enters User as "<user>" and Password as "<password>"
    Then Login button should be disabled
    And Close Browser
    Examples:
      | user   | password |
      | oskmad |          |
      |        | oskmad   |
      |        |          |

