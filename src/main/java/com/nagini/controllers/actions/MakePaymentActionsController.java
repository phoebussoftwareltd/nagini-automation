package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class MakePaymentActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public MakePaymentActionsController clickOnMakePaymentLink(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(
      By.xpath("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[3]/a")));
    driver
      .findElement(By.xpath("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[3]/a"))
      .click();
  return this;
  }

  public MakePaymentActionsController clickOnRepaymentCalculatorLink() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mp-overpaymentsLink")));
    driver.findElement(By.id("mp-overpaymentsLink")).click();
    return this;
  }



}
