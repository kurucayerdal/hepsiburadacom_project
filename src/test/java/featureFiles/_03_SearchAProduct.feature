Feature: Search a product

  Background:
    Given Navigate to website
    Given User should login with a valid username and password

    Scenario: Search a product
      Given Write "samsung" to search space and click on search button
      And Verify that all the results include "samsung"
      And Click on page two and verify that user is on the page two
      And Click on the fifth product and click on the like button
      And Check up that the product is in your liked list and click on liked list
      And Add the product in your cart which you add your liked list
      And Delete the product that you added to your cart
      Then The product should be deleted in your cart

