Feature: Feature to validate positive response code received

  Scenario Outline: Check positive response code
    Given API for foreign exchange
    When posted with future date information
    Then validate positive response code received
