Feature: Verify that users can login
  Automation for Verification that users can login

  Scenario Outline: Verify that users can login
    Given I visit Identity client mock page
    And I click on link Log in with id.nature.com requesting email profile scope
    And I enter email as "<email>" in login page
    And I enter password as "<password>" in login page
    When I click on submit button
    Then I see a confirmation page
    Then login button should be disabled
    Examples:
      | email                | password   |
      | identity11@gmail.com | password12 |