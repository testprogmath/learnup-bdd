package ru.learnup.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

   private SelenideElement userNameField = $("#user-name");
    private SelenideElement passwordField = $("#password");
    private SelenideElement loginButton = $("#login-button");

    public SelenideElement getUsername() {
        return userNameField;
    }

    public SelenideElement getPassword() {
        return passwordField;
    }

    public SelenideElement getLoginButton() {
        return loginButton;
    }
}
