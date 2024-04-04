@all @login
Feature: User Login
#Login feature file
  Background:
    Given User open the application URL

  @validCredentials @smoke @regression
  Scenario Outline: Login using valid conditions
    When User navigates to Login Page
    And User enters valid <Email> address
    And User enters valid passwords <Password>
    Then User should login successfully

    Examples:
      | Email                  | Password       |
      | jatingupta543@gmail.co | Mm@8zKPANUMLHL |
      | jatingupta543@gmail.co | Mm@8zKPANUMLHL |
      | jatingupta543@gmail.co | Mm@8zKPANUMLHL |

  @invalidCredentials @smoke @dev
  Scenario Outline: Login using invalid credentials
    When User navigates to Login Page
    And User enters invalid Email address <Email>
    And User enters invalid passwords <Password>
    Then User should not login successfully
    But User should get a proper warning message
    Examples:
      | Email                   | Password |
      | jatingupta543@gmail.com | Mm@8     |
      | jatingupta543@gmail.c   | mMLHL    |
      | jatingupta543@gmail.o   | UMLHL    |

  @invalidEmail @validPassword @smoke @wip
  Scenario Outline: Login using invalid Email and valid Password
    When User navigates to Login Page
    And User enters invalid Email address <Email>
    And User enters valid passwords <Password>
    Then User should not login successfully
    But User should get a proper warning message
    Examples:
      | Email                   | Password       |
      | jatingupta543@gmail.com | Mm@8zKPANUMLHL |

  @validEmail @invalidPassword @smoke
  Scenario Outline: Login using valid Email and invalid Password
    When User navigates to Login Page
    And User enters valid <Email> address
    And User enters invalid passwords <Password>
    Then User should not login successfully
    But User should get a proper warning message
    Examples:
      | Email                  | Password |
      | jatingupta543@gmail.co | ANUMLHL  |

  @noCredentials @smoke
  Scenario Outline: Login using no credentials
    When User navigates to Login Page
    And User enters no Email address <Email>
    And User enters no passwords <Password>
    Then User should not login successfully
    But User should get a proper warning message
    Examples:
      | Email | Password |
      |  " "  |    " "   |