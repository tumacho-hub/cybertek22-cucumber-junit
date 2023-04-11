package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepsDefinitions {

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");

    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");

    }
    @When("user enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("User enters librarian password");

    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User sees the dashboard");

    }

    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("User enters student username");

    }
    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("User enters student password");

    }

    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("User enters admin username");
    }
    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("User enters admin password");
    }



}
