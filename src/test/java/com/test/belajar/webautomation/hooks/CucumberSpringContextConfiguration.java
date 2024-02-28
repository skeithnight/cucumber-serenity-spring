package com.test.belajar.webautomation.hooks;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.test.belajar.webautomation.Application;

/**
 * Class to use spring application context while running cucumber
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = { Application.class })
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public @interface CucumberSpringContextConfiguration {

}
