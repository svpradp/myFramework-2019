Feature: HRM User Creation Functionality

Scenario: Test the user creation on Orange HRM Site

Given Open Chrome 
When user enters valid credentials
And lands on Dashboard Page
And user clicks on Add User and enters details
And Click on Save
Then the user should get created



 