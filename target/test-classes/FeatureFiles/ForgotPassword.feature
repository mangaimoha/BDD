@password
Feature: To Validate the Forgot Password functionality in Adactin hotel application

  Background: 
    Given User enters Adactin Page

  @smoke
  Scenario: To valdiate by providing valid email ID.
    When User go to forgot password page and enter valid email ID
      | abc@gmail.com | mangaimanivel@gmail.com | 9597803319 | mangaimanivel20oct1995@gmail.com | Selenium@Java |
    Then Close the browser

  @sanity
  Scenario Outline: To valdiate by providing Invalid email ID.
    When User go to forgot password page and enter Invalid "<email>" ID
    Then Close the browser

    Examples: 
      | email         |
      | mangaimanivel |
      | abc@gmail.com |
      |    9597803319 |
