
Feature: Form Authentication

  @smoke @login
  Scenario Outline: Login with multiple credentials
    Given User is on the Login page
    When User enters username "<username>" and password "<password>"
    Then User should see message "<message>"

    Examples:
      | username  | password             | message                         |
      | tomsmith  | SuperSecretPassword! | You logged into a secure area!  |
      | tomsmith  | wrongpass            | Your password is invalid!       |
      | wronguser | SuperSecretPassword! | Your username is invalid!       |
