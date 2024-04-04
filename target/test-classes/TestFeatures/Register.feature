@all @register
Feature: User Registration

  Background:
    Given User navigate to registration page

  @registerMandatoryFields @smoke @regression
  Scenario: Register with only mandatory fields

    When User enters below account details
      | Firstname        | Jatin                     |
      | Lastname         | Gupta                     |
      | Telephone        | 9145994445                |
      | Password         | 12345                     |
      | ConfirmPassword  | 12345                     |

    And User select Privacy Policy feild
    And User click on continue button
    Then user logs in

  @registerAllFields
  Scenario: Register with all feilds

    When User enters below account details
      | Firstname        | Jatin                     |
      | Lastname         | Gupta                     |
      | Telephone        | 9145994445                |
      | Password         | 12345                     |
      | ConfirmPassword  | 12345                     |

    And User select Privacy Policy feild
    And User click on continue button
    Then user logs in

  @registerNoFields
  Scenario: Register with no feilds
    When User does not enter anything
    And User click on continue button
    Then User gets warning message and registration fails
