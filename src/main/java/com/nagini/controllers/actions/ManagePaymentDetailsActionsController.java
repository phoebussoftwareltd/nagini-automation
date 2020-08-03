package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class ManagePaymentDetailsActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public ManagePaymentDetailsActionsController clickOnManagePaymentDetails() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[5]/a" ) ) );
    driver.findElement(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[5]/a" ) ).click();
    return this;
  }

  public ManagePaymentDetailsActionsController clickUndo() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions
      .visibilityOfElementLocated( By.xpath( "//*[@id=\"monthlyPaymentAmount\"]/div/div[2]/div[1]/div/div[1]/a/i" ) ) );
    WebElement undo =
      driver.findElement( By.xpath( "//*[@id=\"monthlyPaymentAmount\"]/div/div[2]/div[1]/div/div[1]/a/i" ) );
    if (undo.isDisplayed())
      undo.click();
    return this;
  }

  public ManagePaymentDetailsActionsController enterNewMonthlyPayment() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "mp-newPayment" ) ) );
    driver.findElement( By.id("mp-newPayment") ).sendKeys("250.00");
    driver.findElement(By.id("mp-button")).click();
    return this;
  }
}
