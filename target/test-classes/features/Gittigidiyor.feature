Feature: Gittigidiyor Page Scenarios

  Scenario: user opens gittigidiyor and search for item
    Given user navigates to gittigidiyor website
    When  user searchs for 'bilgisayar'
    And user navitages to second page
    Then user is on the second page

  Scenario: user selects an item and add to basket
    Given user is on the second page
    When user adds random item to basket
    Then user validates item price

  Scenario: user increases the item count on basket
    When user increases the count
    Then user checks item count

  Scenario: user deleted item from basket
    When user deleted the item
    Then user validates empty basket