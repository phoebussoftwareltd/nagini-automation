package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class LandingPageVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public LandingPageVerifyController LoginPageIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
    assertTrue(driver.findElement(By.id("loginButton")).isDisplayed());

    return this;
  }

  public LandingPageVerifyController RegisterProfileIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerProfileTitle")));
    assertTrue(driver.findElement(By.id("registerProfileTitle")).isDisplayed());
    return this;
  }


}
