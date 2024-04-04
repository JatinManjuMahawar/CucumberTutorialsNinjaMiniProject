@all
Feature: Search Check
  As a user I want to be able to search app for my desired product

Background:
  Given User navigates to search

  @searchValidProduct
  Scenario: Search for valid product that exists
    When User enters product name in searchbar
    And User presses search button
    Then User is able to see the product

  @searchInvalidProduct
  Scenario: Search for invalid product that does not exists
    When User enters product name in searchbar
    And User presses search button
    Then User should not be able to see the product

  @searchNoWords
  Scenario: Search with no words
    When User enters nothing in searchbar
    And User presses search button
    Then User should stay on the same page
