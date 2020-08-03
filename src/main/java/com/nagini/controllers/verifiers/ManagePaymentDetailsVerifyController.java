package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ManagePaymentDetailsVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public ManagePaymentDetailsVerifyController managePaymentDetailsIsDisplayed() throws InterruptedException {
    Thread.sleep(1000);
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id("mp-monthlyPaymentAmountTitle")));
    assertTrue(driver.findElement(By.id("mp-monthlyPaymentAmountTitle")).isDisplayed());
    return this;
  }

  public ManagePaymentDetailsVerifyController repaymentMethodMessageAcknowledged() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mp-changeResponse\"]/span")  ));
    String messageAcknowledged = driver.findElement( By.xpath("//*[@id=\"mp-changeResponse\"]/span") ).getText();
    assertEquals(messageAcknowledged,"Request sent, we will contact you soon");
    return this;

  }


}
