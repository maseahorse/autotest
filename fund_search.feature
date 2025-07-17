Feature: HSBC Investment Funds Search and Validation
  As an investor
  I want to search for HSBC funds
  So that I can view fund details and validate fund information

  Background:
    Given I am on the HSBC investment funds website

  @smoke @search
  Scenario: TC001 - Search for HSBC Asia ex Japan Equity Fund
    When I enter "hsbc" in the quick search field
    And I select "HSBC Asia ex Japan Equity Fund (Class AD) U40093" from the dropdown
    Then I should see the fund details page

#  @validation @pdf
#  Scenario: TC002 - Validate PDF contains required text
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I click on "Factsheet / Key fact statement" link
#    Then the PDF should contain text "ASIA EX JAPAN EQUITY"

#  @navigation
#  Scenario: TC003 - Verify fund basic information display
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    Then I should see fund name "HSBC Asia ex Japan Equity Fund"
#    And I should see fund class "Class AD"
#    And I should see fund code "U40093"
#
#  @performance
#  Scenario: TC004 - Check fund performance data availability
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I navigate to the performance section
#    Then I should see performance data charts
#    And I should see year-to-date performance
#
#  @documents
#  Scenario: TC005 - Verify all document links are accessible
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I check the documents section
#    Then I should see "Factsheet" link
#    And I should see "Key fact statement" link
#    And all document links should be clickable
#
#  @search @negative
#  Scenario: TC006 - Search with invalid fund name
#    When I enter "invalid_fund_xyz" in the quick search field
#    Then I should see no search results
#    And I should see a message "No funds found"
#
#  @search @partial
#  Scenario: TC007 - Search with partial fund name
#    When I enter "Asia ex Japan" in the quick search field
#    Then I should see search results containing "HSBC Asia ex Japan Equity Fund"
#    And I can select the fund from results
#
#  @details @fees
#  Scenario: TC008 - Verify fund fees and charges information
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I navigate to fees and charges section
#    Then I should see management fee information
#    And I should see initial charge details
#
#  @details @investment
#  Scenario: TC009 - Check minimum investment requirements
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I view investment details
#    Then I should see minimum initial investment amount
#    And I should see minimum subsequent investment amount
#
#  @functionality @compare
#  Scenario: TC010 - Add fund to comparison basket
#    Given I search and select "HSBC Asia ex Japan Equity Fund (Class AD) U40093"
#    When I click "Add to compare" button
#    Then the fund should be added to comparison basket
#    And comparison basket count should be 1