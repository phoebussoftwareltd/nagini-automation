package com.nagini.controllers.verifiers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertEquals;

public class RepaymentCalculatorVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();
  private static final String NEW_TERM = "26";


  public RepaymentCalculatorVerifyController newRepaymentTerm() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( "potentialTermReduction" ) ) );
    assertEquals( driver.findElement( By.id( "potentialTermReduction" ) ).getText(), NEW_TERM );
    return this;
  }

  public RepaymentCalculatorVerifyController paymentDetailsAreDisplayed() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until( ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[@id=\"paymentTitle\"]/h1" ) ) );
    assertEquals( driver.findElement( By.xpath( "//*[@id=\"paymentTitle\"]/h1" ) ).getText(), "Make a Payment" );
    return this;
  }


  public RepaymentCalculatorVerifyController requestSentMessage() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath( "//*[@id=\"redemption-changeResponse\"]/span" ) ));
    String redemptionRequestMessage = driver.findElement( By.xpath( "//*[@id=\"redemption-changeResponse\"]/span" ) ).getText();
    assertEquals(redemptionRequestMessage,"Request sent, we will contact you soon");
    return this;
  }
}
