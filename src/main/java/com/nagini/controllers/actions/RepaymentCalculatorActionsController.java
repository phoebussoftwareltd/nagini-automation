package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class RepaymentCalculatorActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public RepaymentCalculatorActionsController enterManualOptionOnSinglePaymentsTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "enterManually" ) ) );
    driver
      .findElement( By.id( "enterManually" ) )
      .click();

    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "rmf-amount" ) ) );
    driver.findElement( By.id( "rmf-amount" ) ).sendKeys( Keys.CONTROL + "a" );
    driver.findElement( By.id( "rmf-amount" ) ).sendKeys( Keys.DELETE );
    driver.findElement( By.id( "rmf-amount" ) ).sendKeys( "1000.00" );
    driver.findElement( By.id( "rmf-amount" ) ).sendKeys( Keys.RETURN );
    return this;
  }

  public RepaymentCalculatorActionsController selectSinglePaymentTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "toggle-1" ) ) );
    driver.findElement( By.id( "toggle-1" ) );
    return this;
  }

  public RepaymentCalculatorActionsController useSliderOption() throws InterruptedException {
    Thread.sleep( 1000 );
    driver.findElement( By.id( "toggle-1" ) ).click();
    {
      WebElement element = driver.findElement( By.xpath( "//*[@id=\"paymentSlider\"]/div/div[3]/div[2]" ) );
      Actions builder = new Actions( driver );
      builder.moveToElement( element ).clickAndHold().perform();
    }

    {
      WebElement element = driver.findElement( By.cssSelector( ".mat-slider-ticks-container" ) );
      Actions builder = new Actions( driver );
      builder.moveToElement( element ).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement( By.cssSelector( ".mat-slider-thumb" ) );
      Actions builder = new Actions( driver );
      builder.moveToElement( element ).release().perform();
    }
    driver.findElement( By.cssSelector( ".mat-slider-wrapper" ) ).click();
    return this;
  }

  public RepaymentCalculatorActionsController clickMakePayment() {
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "rc-singleAdditionalOption" ) ) );
    driver.findElement( By.id( "rc-singleAdditionalOption" ) ).click();
    return this;
  }

  public RepaymentCalculatorActionsController clickOnEditMonthlyPayment() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "rc-recurringAdditionalOption" ) ) );
    // driver
    //   .findElement(By.id("rc-recurringAdditionalOption"))
    //   .click();
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rmf-amount")));
    // assertTrue(driver.findElement(By.id("rmf-amount")).isDisplayed());
    return this;
  }

  public RepaymentCalculatorActionsController RequestRedemptionTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"toggle-3\"]" ) ) );
    driver
      .findElement( By.xpath( "//*[@id=\"toggle-3\"]" ) )
      .click();
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "redemptionTitle" ) ) );
    driver.findElement( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div[2]/div/div[1]" ) )
      .click();
    return this;
  }

  public RepaymentCalculatorActionsController clickRepaymentCalculatorLink() throws InterruptedException {
    Thread.sleep( 2000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[4]/a" ) ) );
    driver
      .findElement(
        By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[4]/a" ) )
      .click();
    return this;
  }


  public RepaymentCalculatorActionsController closeMakePaymentForm() throws InterruptedException {
    Thread.sleep( 2000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "/html/body/modal-container/div/div/app-make-payment/div/div[3]/a" ) ) );
    driver.findElement( By.xpath( "/html/body/modal-container/div/div/app-make-payment/div/div[3]/a" ) ).click();
    return this;
  }

  public RepaymentCalculatorActionsController selectRecurringPaymentTab() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "toggle-2" ) ) );
    driver.findElement( By.id( "toggle-2" ) ).click();
    return this;
  }

  public RepaymentCalculatorActionsController checkIfRequestMadeRecentlyAndReset() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div[1]/a/i" ) ) );
    WebElement undoButton = driver.findElement( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div[1]/a/i" ) );
    if (undoButton.isDisplayed()) {
      undoButton.click();
    }
    return this;
  }

  public RepaymentCalculatorActionsController clickOnRedemptionRequest() {
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div/div[2]/div" ) ) );
    driver.findElement( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-overpayments/div/app-redemption/div/div/div/div[1]/div/div/div[2]/div" ) )
      .click();
    return this;
  }

  public RepaymentCalculatorActionsController selectUseSlider() {
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[@id=\"useSlider\"]" ) ));
    driver.findElement( By.xpath( "//*[@id=\"useSlider\"]" ) ).click();
    return this;
  }
}
