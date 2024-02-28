package com.test.belajar.webautomation.pages;

import com.test.belajar.webautomation.locator.LoginLocator;

public class LoginPage extends BasePage {

    public void typeEmail(String username) {
        typeOnField(LoginLocator.INPUT_USERNAME, username);
    }

    public void typePassword(String password) {
        typeOnField(LoginLocator.INPUT_PASSWORD, password);
    }

    public void clickButtonLogin() {
        clickOnBtn(LoginLocator.BTN_LOGIN);
        webWaitVisibility(LoginLocator.BTN_LOGIN, false, 30);
    }

}
