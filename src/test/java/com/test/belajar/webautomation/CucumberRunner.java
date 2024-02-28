package com.test.belajar.webautomation;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", stepNotifications = true, plugin = {
                "pretty",
                "json:target/destination/cucumber.json",
                "html:target/destination/cucumber-pretty.html",
                "rerun:target/destination/rerun/rerun.txt" }, tags = "@ValidLoginSuperAdmin")
public class CucumberRunner {

}