Feature: freeCRM login feature
Scenario: User is able to login to the freeCRM application

Given user is at the login page
Then user enter username and password
Then user click on login button
Then user is redirected to the home page
Then close the blowser