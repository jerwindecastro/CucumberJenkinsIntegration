Feature: Adding Deals
  @Test1
  Scenario: Login to FreeCrm website
    Given User is on the landing page
    Then User click on the Login button
    Then User enter username and password
  @Test2  
  Scenario: Verify page title and goto Deals menu
    Given User is on the landing page
    Then User click on the Login button
    Then User enter username and password
    Then User is on the homepage
    Then User hover to deals menu
  @Test3  
  Scenario: Add deals data
    Given User is on the landing page
    Then User click on the Login button
    Then User enter username and password
    Then User is on the homepage
    Then User hover to deals menu
    Then User is on the deals page
    Then User fill up title and company name
    Then User click on the save button
