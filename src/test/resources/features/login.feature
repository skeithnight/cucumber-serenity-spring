@LoginFeature @Regression
Feature: Login feature

  @Positive @ValidLoginSuperAdmin
  Scenario: As a super admin, should be able to login using valid credential
    Given User open url browser
    When User do type username "mas_dwiki_testing@mail.com"
    And User do type password "Welcome@1"
    And User do click login button
    Then User should be success login