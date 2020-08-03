package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class AuthenticationVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public AuthenticationVerifyController verifyAuthenticationPageIsDisplayed() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
      "//*[@id=\"cdk-step-content-0-1\"]/app-stepper-content-wrapper/mat-card/div[1]/app-multifactor/div/div/h1")));
    WebElement authenticationHeading = driver.findElement(By.xpath(
      "//*[@id=\"cdk-step-content-0-1\"]/app-stepper-content-wrapper/mat-card/div[1]/app-multifactor/div/div/h1"));
    Assert.assertTrue(authenticationHeading.isDisplayed());
    return this;
  }

}
