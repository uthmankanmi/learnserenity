Feature: verify register button is disabled
  Automation for verification of register button is disabled

  Scenario Outline: verify register button is disabled
    Given I visit Identity client mock page
    And I click on link Log in with id.nature.com requesting email profile scope
    And I enter email as "<email>" in login page
    And I enter password as "<password>" in login page
    When I click on submit button
    Then login button should be disabled
    Examples:
      | email                | password   |
      |                      | password12 |
      | identity11@gmail.com |            |