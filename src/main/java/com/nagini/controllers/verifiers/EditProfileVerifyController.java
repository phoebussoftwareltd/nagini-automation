package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class EditProfileVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();


  public EditProfileVerifyController ChangePasswordIsDisplayed(String linkText) {
    assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    driver.manage().window().maximize();
    return this;
  }

  public EditProfileVerifyController securityQuestionIsDisplayed() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ps-title\"]/h1")));
    assertTrue(driver.findElement(By.xpath("//*[@id=\"ps-title\"]/h1")).isDisplayed());
    return this;
  }

  public EditProfileVerifyController LoginPage(String linkText) {
    assertTrue(driver.findElement(By.linkText(linkText)).isDisplayed());
    driver.manage().window().maximize();
    return this;
  }




}
