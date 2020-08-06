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
    WebElement reset =
      driver.findElement( By.xpath( "//*[@id=\"monthlyPaymentAmount\"]/div/div[2]/div[1]/div/div[1]/a/i" ) );
    if (reset.isDisplayed())
      reset.click();
    return this;
  }

  public ManagePaymentDetailsActionsController enterNewMonthlyPayment() throws InterruptedException {
    Thread.sleep( 1000 );
    Boolean paymentAmountIsVisible = driver.findElement(By.id("mp-newPayment")).isDisplayed();
    if(!paymentAmountIsVisible){
      clickUndo();
    }
    driver.findElement( By.id( "mp-newPayment" ) ).sendKeys( "250.00" );
    driver.findElement( By.id( "mp-button" ) ).click();
    return this;
  }

  public ManagePaymentDetailsActionsController clickPaymentDateTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "toggle-2" ) ) );
    driver.findElement( By.id("toggle-2") ).click();
    return this;
  }

  public ManagePaymentDetailsActionsController enterNewPaymentDay() throws InterruptedException {
    Thread.sleep( 1000 );
    Boolean datePickerIsVisible = driver.findElement(By.xpath("//*[@id=\"paymentDate\"]/div/div[2]/div/form/div/div/div[18]")).isDisplayed();
    if(!datePickerIsVisible){
      clickUndo();
    }
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[@id=\"paymentDate\"]/div/div[2]/div/form/div/div/div[12]" ) ) );
    driver.findElement( By.xpath("//*[@id=\"paymentDate\"]/div/div[2]/div/form/div/div/div[12]") ).click();

    return this;
  }

  public ManagePaymentDetailsActionsController clickRequestDateChange() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "pd-button" ) ) );
    driver.findElement(By.id("pd-button")).click();
    return this;
  }

  public ManagePaymentDetailsActionsController clickDirectDebitTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "toggle-3" ) ) );
    driver.findElement( By.id("toggle-3") ).click();
    return this;
  }
}
