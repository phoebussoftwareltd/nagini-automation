package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class StatementsActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public StatementsActionsController clickOnStatementsLink() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[6]/a" ) ) );
    driver.findElement(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[6]/a" ) ).click();
    return this;
  }

  public StatementsActionsController selectStatementYear() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"statements\"]/app-pdf-stepper/div/div/ul/li[1]" ) ) );
    driver.findElement(
      By.xpath( "//*[@id=\"statements\"]/app-pdf-stepper/div/div/ul/li[1]" ) ).click();
    return this;
  }

  public StatementsActionsController selectDownloadStatement() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"download\"]/i" ) ) );
    driver.findElement(
      By.xpath( "//*[@id=\"download\"]/i" ) ).click();
    return this;
  }
}
