package com.test.belajar.webautomation.locator;

public interface LoginLocator {
    String INPUT_USERNAME = "//input[@id='username']";
    String INPUT_PASSWORD = "//input[@id='password']";
    String BTN_LOGIN = "//button[normalize-space()='Masuk']";

    String ERROR_LOGIN_MESSAGE = "//div[contains(text(),'Mohon maaf username atau password anda salah. Hubungi Admin jika terjadi berulang kali.')]";

}