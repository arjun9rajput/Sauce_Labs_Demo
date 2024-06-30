Feature: Swag Labs Inventory Scenarios assignment

  Scenario : Login Swag Labs and select Inventory
    Given I am on Swag Labs Login Page
    When I enter username as "standard_user" and password as "secret_sauce"
    And I click Login Button
    And I verify I am on Inventory page
    And I add 3 items to the cart
    And I verify "3" items are added to the cart
    Then I verify I am on cart page
    And I verify total items on the cart page is 3
    Then I click checkout button
    Then I should see the address page
    Then I enter "test" as first name
    Then I enter "case" as last name
    Then I enter "000000" as zipcode
    Then I click on continue button
    And I verify checkout page is displayed
    Then I verify total items on the checkout page is 3
    And I verify correct total price is displayed
    And I click on finish button
    Then I should see the finish page
    Then I click on back home button

    Scenario: Verify user is able to remove items from cart
      Given I am on Swag Labs Login Page
      When I enter username as "standard_user" and password as "secret_sauce"
      And I click Login Button
      And I verify I am on Inventory page
      And I add 3 items to the cart
      And I verify "3" items are added to the cart
      Then I verify I am on cart page
      And I verify total items on the cart page is 3
      And I remove one item from the cart
      Then I verify total items on the cart page is 2


