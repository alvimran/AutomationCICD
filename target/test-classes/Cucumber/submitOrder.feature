
@tag
Feature: purchase order from Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page
	
  @Regression
  Scenario Outline: Postive test case for submitting order
    Given Logged in with username "<name>" and password "<password>"
    When I add product "<ProductName>" to cart
    And Chekout "<ProductName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage
    
  


    Examples: 
      | name  						| password 				| ProductName  |
      | alvi123@gmail.com | Imrankhan123 | ZARA COAT 3  |
   
