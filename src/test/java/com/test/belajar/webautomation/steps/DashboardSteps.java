package com.test.belajar.webautomation.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.belajar.webautomation.locator.DashboardLocator;
import com.test.belajar.webautomation.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DashboardSteps extends ScenarioSteps {

    @Autowired
    LoginPage loginPage;

    @Given("User open url browser")
    public void User_open_url_browser() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.navigateToURL("https://dev-hms.ugems.id/login");
    }

    @When("User do type username {string}")
    public void User_do_type_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.typeEmail(username);
    }

    @When("User do type password {string}")
    public void User_do_type_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.typePassword(password);
    }

    @When("User do click login button")
    public void User_do_click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickButtonLogin();
    }

    @Then("User should be success login")
    public void User_should_be_success_login() {
        // Write code here that turns the phrase above into concrete actions
        assertThat("Dashboard Title is not visible",
                loginPage.webWaitIsVisibility(DashboardLocator.TITTLE_DASHBOARD, 30),
                equalTo(true));
    }

}
