package com.nagini.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class RepaymentCalculatorPage {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();


  public RepaymentCalculatorPage verifyEnterNanualOption() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.id("enterManually")));
    driver
      .findElement(By.id("enterManually"))
      .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rmf-amount")));
    assertTrue(driver.findElement(By.id("rmf-amount")).isDisplayed());
    return this;
  }

  public RepaymentCalculatorPage verifyEditMonthlyPayment() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.id("rc-recurringAdditionalOption")));
    // driver
    //   .findElement(By.id("rc-recurringAdditionalOption"))
    //   .click();
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rmf-amount")));
    // assertTrue(driver.findElement(By.id("rmf-amount")).isDisplayed());
    return this;
  }

  public RepaymentCalculatorPage verifyRequestRedemptionSuccess() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.xpath("//*[@id=\"toggle-3\"]")));
    driver
      .findElement(By.xpath("//*[@id=\"toggle-3\"]"))
      .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("redemptionTitle")));
    assertTrue(driver.findElement(By.id("redemptionTitle")).isDisplayed());
    driver.findElement(By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div[2]/div/div[1]"))
      .click();
    Thread.sleep(1000);
    assertTrue(driver.findElement(By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div[2]/div/div[1]"))
      .isDisplayed());
    return this;
  }

  public RepaymentCalculatorPage verifyUseliderOption() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.id("useSlider")));
    driver
      .findElement(By.id("useSlider"))
      .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enterManually")));
    assertTrue(driver.findElement(By.id("enterManually")).isDisplayed());
    return this;
  }
}
