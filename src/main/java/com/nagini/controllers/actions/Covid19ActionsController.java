package com.nagini.controllers.actions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class Covid19ActionsController {

  private final WebDriver driver = getChromeDriver();
  private final WebDriverWait wait = getWebDriverWait();

  public Covid19ActionsController clickCovid19Link() throws InterruptedException {
    Thread.sleep( 2000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[9]/a" ) ) );
    driver
      .findElement(
        By.xpath( "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[9]/a" ) )
      .click();
    return this;
  }

  public Covid19ActionsController enterDetailsForPaymentHolidayCallBack() throws InterruptedException {
    Thread.sleep( 2000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-contactTel" ) ) );
    driver
      .findElement(
        By.id( "ph-contactTel" ) ).sendKeys( "07656564343" );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-timeOfContact" ) ) );
    driver
      .findElement(
        By.id( "ph-timeOfContact" ) ).click();
    driver
      .findElement(
        By.id( "ph-timeOfContact" ) ).sendKeys( "17:00" );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-option1" ) ) );
    driver
      .findElement(
        By.id( "ph-option1" ) ).click();
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-option2" ) ) );
    driver
      .findElement(
        By.id( "ph-option2" )).click();
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-option3" ) ) );
    driver
      .findElement(
        By.id( "ph-option3" ) ).click();
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-option4" ) ) );
    driver
      .findElement(
        By.id( "ph-option4" ) ).click();
    return this;
  }

  public Covid19ActionsController clickRequestPaymentHoliday() throws InterruptedException {
    Thread.sleep( 2000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated(
      By.id( "ph-requestButton" ) ) );
    driver
      .findElement(
        By.xpath( "ph-requestButton" ) ).click();

    return this;
  }
}
