Feature: Student Registration
  As a school administrator
  I want to register new students
  So that I can maintain student records

  Scenario: Save student with only name
    Given I want to register a new student
    When I enter the student name "Mario"
    Then the student should be saved successfully
    And I should see the confirmation message