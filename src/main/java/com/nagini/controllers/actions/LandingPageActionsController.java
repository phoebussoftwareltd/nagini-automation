package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class LandingPageActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();
  private static String url = "http://nagini-test-ui.phoebus-internal.com/";

  public LandingPageActionsController clickOnLoginButton(){
    driver.get(url);
    driver.findElement(By.id("loginBtn")).click();
    return this;
  }

  public LandingPageActionsController clickOnRegisterButton(){
    driver.get(url);
    driver.findElement(By.id("registerBtn")).click();
    return this;
  }




}
