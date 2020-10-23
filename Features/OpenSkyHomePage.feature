Feature: OpenSky Login

  Scenario: Logo presence on OrangeHRM home Page
    Given I launch chrome browser
    When I open OpenSky homepage
    Then I verify that the logo present on page
    And close browser