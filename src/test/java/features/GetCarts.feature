Feature: Get all carts from the api

  Scenario: Verify the get api for the carts
    Given I hit the url of get carts api endpoint
    When I pass the url of carts in the request
    Then I receive the response code for carts api as 200

  #@RegressionTest
  Scenario Outline: Verify the total number of products in the first cart is correct
    Given I hit the url of get carts api endpoint
    When I pass the url of carts in the request
    Then I verify that the total number of the products in the first cart is <FirstcartTotalProducts>
    Examples:
      | FirstcartTotalProducts |
      | 11                     |