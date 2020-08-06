package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class RedemptionsActionsController {
  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public RedemptionsActionsController clickRedemptionsLink() {
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[8]/a" ) ) );
    driver.findElement( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[8]/a" ) )
      .click();
    return this;
  }

  public RedemptionsActionsController checkIfRequestMadeRecentlyAndReset() throws InterruptedException {
    Thread.sleep( 1000 );
    WebElement redemptionButton = driver.findElement( By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-redemption/div/div/div/div[1]/div/div/div[2]/div" ) );

    if (!redemptionButton.isDisplayed()) {
      driver.findElement( By.xpath(
        "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-redemption/div/div/div/div[1]/div/div[1]/a/i" ) )
        .click();
    }
    redemptionButton.click();
    return this;
  }
}
