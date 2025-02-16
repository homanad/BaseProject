Feature: Get Somethings

  @development
  Scenario: Get somethings data successfully
    Given I start the application
    When I click somethings button
    Then I expect to see somethings data