Feature: I want to login as admin, add user, delete user, check records

  Scenario Outline: Login, Add user, Delete user
    Given Login page is displayed
    When The user enters valid login credentials username <username> and password <password>
    Then Admin main page is displayed
    Then Navigate to Admin Screen
    Then Get Records Number
    Then Add User with username <name> and password <pass>
    Then Get Records Number
    Then Validate Records After Add
    Then Search for the user with <name>
    Then Delete the new user
    Then Get Records Number
    Then Validate Records After Delete
    Examples:
      | username     | password     | name     | pass|
      | "Admin" | "admin123" | "OmarIbrahim" | "1234567Oo"|