package com.test.belajar.webautomation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;

@Component
public class BasePage extends UIInteractions {
    public void waitUntil(String locator, Integer second) {
        withTimeoutOf(Duration.ofSeconds(second))
                .waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void webWaitVisibility(String locator, boolean visible, int timeout) {
        Duration durationInMinutes = Duration.ofSeconds(timeout);
        WebDriverWait wait = new WebDriverWait(getDriver(), durationInMinutes);
        try {
            if (visible) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            } else {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean webWaitIsVisibility(String locator, int timeout) {
        Boolean result = false;
        try {
            webWaitVisibility(locator, true, timeout);
            result = isVisible(locator);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return result;
    }

    public void webWaitUrlContain(String url, int timeout) {
        Duration durationInMinutes = Duration.ofSeconds(timeout);
        WebDriverWait wait = new WebDriverWait(getDriver(), durationInMinutes);
        wait.until(ExpectedConditions.urlContains(url));
    }

    public void scrollToItemOnCenterView(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

        ((JavascriptExecutor) getDriver()).executeScript(scrollElementIntoMiddle, element);

    }

    public WebElementFacade findElementUntilVisible(String locator) {
        webWaitVisibility(locator, true, 10);
        scrollToItemOnCenterView(find(By.xpath(locator)));
        return find(By.xpath(locator)).withTimeoutOf(Duration.ofSeconds(10)).waitUntilVisible();
    }

    public WebElementFacade findElementUntilClickable(String locator) {
        return find(By.xpath(locator)).withTimeoutOf(Duration.ofSeconds(10)).waitUntilClickable();
    }

    public void typeOnField(String locator, String value) {
        waitUntil(locator, 5);
        findElementUntilVisible(locator).clear();
        findElementUntilVisible(locator).type(new CharSequence[]{value});
    }

    public void clickOnBtn(String locator) {
        WebElementFacade button = findElementUntilClickable(locator);

        scrollToItemOnCenterView(button);

        button.click();
    }

    public boolean isVisible(String locator) {
        return find(By.xpath(locator)).isVisible();
    }

    public void navigateToURL(String string) {
        openAt(string);
        webWaitUrlContain(string, 10);
    }
    

}
