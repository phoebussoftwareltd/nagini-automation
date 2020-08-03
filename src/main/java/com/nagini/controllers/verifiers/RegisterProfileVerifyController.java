package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class RegisterProfileVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public RegisterProfileVerifyController mortgageAddressPostodeIsRequested(){
    assertTrue(driver.findElement(By.id("addressTitle")).isDisplayed());
    return this;
  }

  public RegisterProfileVerifyController securityIsRequested(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(" Single Payment ")));
    assertTrue(driver.findElement(By.id("securityTitle")).isDisplayed());
    return this;
  }

  public RegisterProfileVerifyController knowYourCustomerIsRequired() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verificationTitle")));
    assertTrue(driver.findElement(By.id("verificationTitle")).isDisplayed());
    return this;
  }
}
