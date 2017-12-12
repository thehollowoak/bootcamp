Feature: Calculator
  Scenario: Add 2 numbers
    Given I enter 2 and 3
    When I add the numbers
    Then the result should be 5

  Scenario: Add 2 negative numbers
    Given I enter -2 and -3
    When I add the numbers
    Then the result should be -5

  Scenario: Subtract 2 numbers
    Given I enter 5 and 3
    When I subtract the numbers
    Then the result should be 2

  Scenario: Multiply 2 numbers
    Given I enter 5 and 3
    When I multiply the numbers
    Then the result should be 15

  Scenario: Divide 2 numbers
    Given I enter 6 and 3
    When I divide the numbers
    Then the result should be 2
