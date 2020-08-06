package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static jdk.nashorn.internal.objects.NativeString.substr;

public class PageActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public PageActionsController getHeaderElements() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBannerForm")));
    String abBalance = driver.findElement(By.xpath("//*[@id=\"ab-balance\"]/div[1]")).getText();
    String abInterest = substr(driver.findElement(By.id("ab-interest")).getText(), 0, 5);
    String abInstalment = substr(driver.findElement(By.id("ab-instalment")).getText(), 0, 7);
    return this;
  }

  public PageActionsController clickOnMakePaymentWithinHeader() {
    // Check Make Payment Button within Header section
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBannerForm")));
    driver.findElement(By.id("ab-makePayment")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentTitle")));
    return this;
  }

  public PageActionsController clickMenuOption(String xpathLink,String titlePage) throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.xpath(xpathLink)));
    driver
      .findElement(By.xpath(xpathLink))
      .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(titlePage)));
    return this;
  }
}
