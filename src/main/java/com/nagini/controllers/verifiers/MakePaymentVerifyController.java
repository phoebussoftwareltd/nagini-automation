package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class MakePaymentVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public MakePaymentVerifyController makePaymentIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentTitle")));
    assertTrue(driver.findElement(By.id("paymentTitle")).isDisplayed());
    return this;
  }

  public MakePaymentVerifyController verifyRepaymentCalculatorLink() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("singlePaymentTitle")));
    assertTrue(driver.findElement(By.id("singlePaymentTitle")).isDisplayed());
    return this;
  }



}
