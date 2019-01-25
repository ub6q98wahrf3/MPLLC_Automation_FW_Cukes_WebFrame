$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GMail_Login.feature");
formatter.feature({
  "line": 1,
  "name": "GMail Login",
  "description": "",
  "id": "gmail-login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5945822799,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "GMail Login",
  "description": "",
  "id": "gmail-login;gmail-login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@GmailTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User clicks on the Sign In button on the homepage",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User enters \"love.vashista@mobileprogramming.net\" on the username page",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User enters \"password12345\" on the password page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "The user should be redirected on the same page with an error message: \"Wrong password. Try again or click Forgot password to reset it.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition_GMail_Login.user_clicks_on_the_Sign_In_button_on_the_homepage()"
});
formatter.result({
  "duration": 42573993817,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "love.vashista@mobileprogramming.net",
      "offset": 13
    }
  ],
  "location": "stepDefinition_GMail_Login.user_enters_something_on_the_username_page(String)"
});
formatter.result({
  "duration": 2003096293,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "password12345",
      "offset": 13
    }
  ],
  "location": "stepDefinition_GMail_Login.user_enters_something_on_the_password_page(String)"
});
formatter.result({
  "duration": 1874777234,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Wrong password. Try again or click Forgot password to reset it.",
      "offset": 71
    }
  ],
  "location": "stepDefinition_GMail_Login.the_user_should_be_redirected_on_the_same_page_with_an_error_message(String)"
});
formatter.result({
  "duration": 577720724,
  "status": "passed"
});
formatter.after({
  "duration": 196717089,
  "status": "passed"
});
formatter.uri("Rediff_Login.feature");
formatter.feature({
  "line": 1,
  "name": "Rediff Login",
  "description": "",
  "id": "rediff-login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Rediff Login",
  "description": "",
  "id": "rediff-login;rediff-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RediffTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "The user is on the rediff homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The user enters \u003cUsername\u003e and password \u003cPassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Unchecks the Keep Me Sign In checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The user should get redirected to the same page",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "rediff-login;rediff-login;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 12,
      "id": "rediff-login;rediff-login;;1"
    },
    {
      "cells": [
        "a@aa.com",
        "11111"
      ],
      "line": 13,
      "id": "rediff-login;rediff-login;;2"
    },
    {
      "cells": [
        "b@bb.com",
        "22222"
      ],
      "line": 14,
      "id": "rediff-login;rediff-login;;3"
    },
    {
      "cells": [
        "c@cc.com",
        "33333"
      ],
      "line": 15,
      "id": "rediff-login;rediff-login;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 2519916030,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Rediff Login",
  "description": "",
  "id": "rediff-login;rediff-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RediffTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "The user is on the rediff homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The user enters a@aa.com and password 11111",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Unchecks the Keep Me Sign In checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The user should get redirected to the same page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_is_on_the_rediff_homepage()"
});
formatter.result({
  "duration": 11582594,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "a@aa.com",
      "offset": 16
    },
    {
      "val": "11111",
      "offset": 38
    }
  ],
  "location": "stepDefinition_RediffMail_Login.the_user_enters_and_password(String,String)"
});
formatter.result({
  "duration": 2522569055,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.unchecks_the_keep_me_sign_in_checkbox()"
});
formatter.result({
  "duration": 614850972,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.Clicks_on_Login_Button()"
});
formatter.result({
  "duration": 984870390,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_should_get_redirected_to_the_same_page()"
});
formatter.result({
  "duration": 5899967,
  "status": "passed"
});
formatter.after({
  "duration": 84272996,
  "status": "passed"
});
formatter.before({
  "duration": 2374347490,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Rediff Login",
  "description": "",
  "id": "rediff-login;rediff-login;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RediffTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "The user is on the rediff homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The user enters b@bb.com and password 22222",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Unchecks the Keep Me Sign In checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The user should get redirected to the same page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_is_on_the_rediff_homepage()"
});
formatter.result({
  "duration": 14016405,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "b@bb.com",
      "offset": 16
    },
    {
      "val": "22222",
      "offset": 38
    }
  ],
  "location": "stepDefinition_RediffMail_Login.the_user_enters_and_password(String,String)"
});
formatter.result({
  "duration": 2186893615,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.unchecks_the_keep_me_sign_in_checkbox()"
});
formatter.result({
  "duration": 616792537,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.Clicks_on_Login_Button()"
});
formatter.result({
  "duration": 878285071,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_should_get_redirected_to_the_same_page()"
});
formatter.result({
  "duration": 4925302,
  "status": "passed"
});
formatter.after({
  "duration": 131095234,
  "status": "passed"
});
formatter.before({
  "duration": 2159140976,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Rediff Login",
  "description": "",
  "id": "rediff-login;rediff-login;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@RediffTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "The user is on the rediff homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "The user enters c@cc.com and password 33333",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Unchecks the Keep Me Sign In checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Clicks on Login Button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The user should get redirected to the same page",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_is_on_the_rediff_homepage()"
});
formatter.result({
  "duration": 14801330,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "c@cc.com",
      "offset": 16
    },
    {
      "val": "33333",
      "offset": 38
    }
  ],
  "location": "stepDefinition_RediffMail_Login.the_user_enters_and_password(String,String)"
});
formatter.result({
  "duration": 2215792359,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.unchecks_the_keep_me_sign_in_checkbox()"
});
formatter.result({
  "duration": 600992182,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.Clicks_on_Login_Button()"
});
formatter.result({
  "duration": 891617724,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinition_RediffMail_Login.the_user_should_get_redirected_to_the_same_page()"
});
formatter.result({
  "duration": 4985071,
  "status": "passed"
});
formatter.after({
  "duration": 81044936,
  "status": "passed"
});
});