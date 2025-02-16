Feature: Get Something

  @production
  Scenario Outline: Get something data successfully
    Given I start the application
    When I click id field
    And I type <id>
    And I close keyboard
    And I click something button
    Then I expect to see something data
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |