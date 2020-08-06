package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertEquals;

public class RedemptionsVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public RedemptionsVerifyController requestSentMessage() throws InterruptedException {
    Thread.sleep(1000);
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[@id=\"redemption-changeResponse\"]/span" ) ));
    String redemptionRequestMessage = driver.findElement( By.xpath( "//*[@id=\"redemption-changeResponse\"]/span" ) ).getText();
    assertEquals(redemptionRequestMessage,"Request sent, we will contact you soon");
    return this;

  }
}
