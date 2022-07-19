Feature: Login with parameters

  @student @regression
  Scenario: Login as student 3
    Given I am on the login page
    When I enter username "student3@library"
    And I enter password 'UB1EMJAc'
    And click the sign in button
    Then dashboard should be displayed

  @librarian @regression
  Scenario: Login as librarian 3
    Given I am on the login page
    When I enter username "librarian3@library"
    And I enter password 'Bqq9Ru0W'
    And click the sign in button
    Then dashboard should be displayed
    And there should be "136" users
  #number can be whatever you have there