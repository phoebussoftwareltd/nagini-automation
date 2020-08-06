package com.nagini.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static jdk.nashorn.internal.objects.NativeString.substr;
import static org.testng.Assert.assertTrue;

public class PageObject {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();


  public Object checkHeaderDetails(String balance, String interest, String instalment) throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBannerForm")));
    String abBalance = driver.findElement(By.xpath("//*[@id=\"ab-balance\"]/div[1]")).getText();
    String abInterest = substr(driver.findElement(By.id("ab-interest")).getText(), 0, 5);
    String abInstalment = substr(driver.findElement(By.id("ab-instalment")).getText(), 0, 7);
    Assert.assertEquals(abBalance, balance);//"£21,756.90");
    Assert.assertEquals(abInterest, interest);//"8.29%");
    Assert.assertEquals(abInstalment,instalment);// "£229.09");

    // Check Make Payment Button witthin Header section
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountBannerForm")));
    driver.findElement(By.id("ab-makePayment")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentTitle")));
    assertTrue(driver.findElement(By.id("paymentTitle")).isDisplayed());
    return this;
  }

  public Object clickMenuOption(String xpathLink) throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.xpath(xpathLink)));
    driver
      .findElement(By.xpath(xpathLink))
      .click();
    return this;
  }

  public PageObject clickCSSSelector(String textLink) {
    driver.findElement(By.cssSelector(textLink)).click();
    return this;
  }

    public Object verifyPageIsDisplayedByXpath(Object page,String xpath, String titlePage) throws InterruptedException {
      Thread.sleep(1000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath(xpath)));
      driver
        .findElement(By.xpath(xpath))
        .click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(titlePage)));
      assertTrue(driver.findElement(By.id(titlePage)).isDisplayed());
      return this;
    }

  public Object verifyPageIsDisplayedById(Object page,String id, String titlePage) throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.xpath(id)));
    driver
      .findElement(By.xpath(id))
      .click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(titlePage)));
    assertTrue(driver.findElement(By.id(titlePage)).isDisplayed());
    return this;
  }


}
