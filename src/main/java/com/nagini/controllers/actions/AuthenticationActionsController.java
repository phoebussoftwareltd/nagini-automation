package com.nagini.controllers.actions;

import com.nagini.pages.AccountSummary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.AccountSummary.getAccountSummary;
import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class AuthenticationActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public AuthenticationActionsController clickOnVerifyButton() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyButton")));
    driver.findElement(By.id("verifyButton")).click();
    return this;
  }

  public AuthenticationActionsController enterCode(String code) {
    driver.findElement(By.id("code")).sendKeys(code);
    return this;
  }

  public AccountSummary passControlToAccountSummary() {
    return getAccountSummary();
  }

}
