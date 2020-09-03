package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class Covid19VerifiyController {


  private final WebDriver driver = getChromeDriver();
  private final WebDriverWait wait = getWebDriverWait();

  public Covid19VerifiyController requestAcknowledged() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until(
      ExpectedConditions.visibilityOfElementLocated( By.cssSelector( ".response .swal2-success" ) ) );
    assertTrue( driver.findElement( By.cssSelector( ".response swal2-success" ) ).isDisplayed());
    return this;
  }
}
