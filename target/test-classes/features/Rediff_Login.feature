Feature: Rediff Login

@RediffTest
Scenario Outline: Rediff Login
Given The user is on the rediff homepage
When The user enters <Username> and password <Password>
	And Unchecks the Keep Me Sign In checkbox
	And Clicks on Login Button
Then The user should get redirected to the same page

Examples:
|Username|Password	|
|a@aa.com|11111		|
|b@bb.com|22222		|
|c@cc.com|33333		|