package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MakePaymentVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public MakePaymentVerifyController makePaymentIsDisplayed() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paymentTitle\"]/h1")));
    assertEquals(driver.findElement(By.xpath("//*[@id=\"paymentTitle\"]/h1")).getText(),"Make a Payment");
    return this;
  }

}
