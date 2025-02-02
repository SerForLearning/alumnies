package it.ser.alumnies.serenity.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentRegistrationSteps {

    @Given("I want to register a new student")
    public void iWantToRegisterANewStudent() {
        System.out.println("I want to register a new student");
    }

    @When("I enter the student name {string}")
    public void iEnterTheStudentName(String name) {
        System.out.println("I enter the student name " + name);

    }

    @Then("the student should be saved successfully")
    public void theStudentShouldBeSavedSuccessfully() {
        System.out.println("the student should be saved successfully");

    }

    @And("I should see the confirmation message")
    public void iShouldSeeTheConfirmationMessage() {
        System.out.println("I should see the confirmation message");
    }
}
