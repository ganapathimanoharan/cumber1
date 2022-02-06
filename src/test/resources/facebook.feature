Feature: validate the login function of fb application
Scenario: validate the login by incorrect username and correct password
Given User is on fb page on chrome browser
When user enter the username and password
And click login button
Then user check homepage is visible or not

