package com.test.belajar.webautomation.hooks;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.pages.PageObject;

@Component
@CucumberSpringContextConfiguration
public class CucumberHooks extends PageObject {

  private static final Logger log = LogManager.getLogger(CucumberSpringContextConfiguration.class);

  /**
   * Need this method so the cucumber will recognize this class as glue and load
   * spring context configuration
   */
  @Before
  public void setUp() {
    log.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
  }

  @After
  public void afterRun(Scenario scenario) {
    System.out.println("afterRun");
    if (scenario.isFailed()) {
      try {
        TakesScreenshot scrShot = ((TakesScreenshot) getDriver());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + "/target/screenshots/" + scenario.getName() + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
        // it will executed after scenario run
        takeScreenshot(scenario, getDriver());
        getDriver().quit();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void takeScreenshot(Scenario scenario, WebDriver driver) {
    if (scenario != null && driver != null && scenario.isFailed()) {
      log.info("Scenario is Failed, Taking ScreenShot...!!!");
      byte[] screenshot = takeScreenshot(driver);
      if (screenshot != null) {
        scenario.attach(screenshot, "image/png", "Failed Screenshot");
        log.info("Screenshot is taken!");
      } else {
        log.info("Screenshot is empty...");
      }
    }
  }

  public static byte[] takeScreenshot(WebDriver driver) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    return (byte[]) ts.getScreenshotAs(OutputType.BYTES);
  }

}
