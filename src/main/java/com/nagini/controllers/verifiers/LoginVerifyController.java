package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  private static String url = "http://nagini-test-ui.phoebus-internal.com/";

  public LoginVerifyController loginPageIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginButton")));
    assertTrue(driver.findElement(By.id("LoginButton")).isDisplayed());
    return this;
  }

  public LoginVerifyController userForcedToLogin() {
    String actualText = driver.getCurrentUrl();
    assertEquals(actualText, "http://nagini-test-ui.phoebus-internal.com/reset-password");
    return this;
  }

  public LoginVerifyController registerProfileIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerProfileTitle")));
    assertTrue(driver.findElement(By.id("registerProfileTitle")).isDisplayed());
    return this;
  }
}
