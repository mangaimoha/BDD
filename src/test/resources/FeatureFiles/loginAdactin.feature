
@login
Feature: To validate the login functionality of AdactinHotel application

  Background: 
    Given User enters Adactin Page
    And Maximize the window

  Scenario: To validate login functionality by providing valid username and valid password
    When User to provide valid username and valid password
      | username1 | mangai         |
      | username2 | mangaimohan    |
      | username3 | mangaimanivel  |
      | password1 | Hermione201095 |
      | password2 |        1234567 |
    And Print Current Date
    Then User to validate the output
    And Close the browser

  Scenario: To validate login functionality by providing invalid username and invalid password
    When User to provide invalid username and invalid password
      | username      | password     | email            | phonenumber | ID  |
      | mangaim       |        12345 | abc@gmail.com    |  9597803319 | 101 |
      | mohank        | Sivagami     | mohank@gmail.com |  9500899853 | 102 |
      | mangaimanivel | Hermione2020 |         53296331 |         562 |     |
    And Print Current Date
    Then User to validate the output
    And Close the browser
