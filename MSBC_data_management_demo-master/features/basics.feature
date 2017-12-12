Feature: Filling in the basics of the Survey

  Scenario: Filling out the name
    Given I have a fake name
    When I fill in the name
    Then the name is populated