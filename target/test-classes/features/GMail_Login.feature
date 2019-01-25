Feature: GMail Login

@GmailTest
Scenario: GMail Login
When User clicks on the Sign In button on the homepage
And User enters "love.vashista@mobileprogramming.net" on the username page
And User enters "password12345" on the password page
Then The user should be redirected on the same page with an error message: "Wrong password. Try again or click Forgot password to reset it."

