package ru.learnup.tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.learnup.pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("I open login page")
    public void iOpenLoginPage() {
        open("https://www.saucedemo.com/");
    }

    @When("I fill in login field with {string}")
    public void iFillInLoginFieldWith(String username) {
        loginPage.getUsername().val(username);
    }

    @And("I fill in password field")
    public void iFillInPasswordField() {
        loginPage.getPassword().val("secret_sauce");
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("I am on Inventory page")
    public void iAmOnInventoryPage() {
        assertThat(webdriver().driver().url(), containsString("inventory.html"));
        $("#shopping_cart_container").should(visible);
    }

    @Then("I see an error message {string}")
    public void iSeeAnErrorMessage(String message) {
        $("[data-test='error']").should(text(message));
    }
}
