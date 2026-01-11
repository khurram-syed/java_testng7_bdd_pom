
Feature: A/B Testing Page

  @apTesting
  Scenario: Validate A/B Test Page Header
    Given User visits the AB Testing page
    Then The page header should contain AB Test
