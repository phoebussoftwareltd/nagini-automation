package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static jdk.nashorn.internal.objects.NativeString.substr;
import static org.testng.Assert.assertTrue;

public class PageVerifiyController {
  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public PageVerifiyController verifyHeaderDetails(String balance, String interest, String instalment) {
    String abBalance = driver.findElement(By.xpath("//*[@id=\"ab-balance\"]/div[1]")).getText();
    String abInterest = substr(driver.findElement(By.id("ab-interest")).getText(), 0, 5);
    String abInstalment = substr(driver.findElement(By.id("ab-instalment")).getText(), 0, 7);
    Assert.assertEquals(abBalance, balance);//"£21,756.90");
    Assert.assertEquals(abInterest, interest);//"8.29%");
    Assert.assertEquals(abInstalment, instalment);// "£229.09");
    return this;
  }

  public PageVerifiyController verifyTitleIsDisplayed(String elementId) {
    assertTrue(driver.findElement(By.id(elementId)).isDisplayed());
    return this;
  }



}
