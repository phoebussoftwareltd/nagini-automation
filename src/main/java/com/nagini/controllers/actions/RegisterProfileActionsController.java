package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class RegisterProfileActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public RegisterProfileActionsController fillInProfileDetails() throws InterruptedException {
    Thread.sleep(1000);

    driver.findElement(By.cssSelector(".formGroup-registerDOB .material-icons")).click();
    driver.findElement(By.cssSelector(".current:nth-child(3) > span")).click();
    driver.findElement(By.id("registerDOB")).click();
    driver.findElement(By.id("registerDOB")).sendKeys("01-01-2000");
    driver.findElement(By.id("registerTitle")).click();
    {
      WebElement dropdown = driver.findElement(By.id("registerTitle"));
      dropdown.findElement(By.xpath("//*[@id=\"registerTitle\"]/option[3]")).click();
    }
    driver.findElement(By.id("registerTitle")).click();
    driver.findElement(By.id("registerFirstName")).click();
    driver.findElement(By.id("registerFirstName")).sendKeys("Julie");
    driver.findElement(By.id("registerLastName")).sendKeys("Dabbs");

    driver.findElement(By.id("registerMobile")).sendKeys("07835975372");

    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerEmail")));
    driver.findElement(By.id("registerEmail")).click();
    driver.findElement(By.id("registerEmail")).sendKeys("juliedabbs@hotmail.co.uk");

    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerConfirmEmail")));
    driver.findElement(By.id("registerConfirmEmail")).sendKeys("juliedabbs@hotmail.co.uk");
    driver.findElement(By.id("registerNextButton")).click();

    return this;
  }

  public RegisterProfileActionsController enterMortgageAddressPostcode() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressPostCode")));
    driver.findElement(By.id("addressPostCode")).click();
    driver.findElement(By.id("addressPostCode")).sendKeys("B31");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressSearch")));
    driver.findElement(By.id("addressSearch")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("add manually")));
    driver.findElement(By.linkText("add manually")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressNameNumber")));
    driver.findElement(By.id("addressNameNumber")).click();
    driver.findElement(By.id("addressNameNumber")).sendKeys("65 ");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressStreet")));
    driver.findElement(By.id("addressStreet")).click();
    driver.findElement(By.id("addressStreet")).sendKeys("New Road");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressCityTown")));
    driver.findElement(By.id("addressCityTown")).sendKeys("Solihull");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressCounty")));
    driver.findElement(By.id("addressCounty")).click();
    driver.findElement(By.id("addressCounty")).sendKeys("West Midlands");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addressNext")));
    driver.findElement(By.id("addressNext")).click();
    return this;
  }

  public RegisterProfileActionsController enterSecurityDetails() {
    driver.findElement(By.id("securityQuestion")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securityQuestion"));
      dropdown.findElement(By.xpath("//*[@id=\"securityQuestion\"]/option[2]")).click();
    }
    driver.findElement(By.id("securityQuestion")).click();
    driver.findElement(By.cssSelector("#cdk-step-content-0-2 .card-body")).click();
    driver.findElement(By.id("securityAnswer")).sendKeys("St Marys RC");
    driver.findElement(By.id("securityPassword")).sendKeys("C@ntona7a");
    driver.findElement(By.id("securityConfirmPassword")).sendKeys("C@ntona7a");
    driver.findElement(By.id("securityNext")).click();

    return this;
  }

  public RegisterProfileActionsController enterPhoebusAccountDetails() {
    driver.findElement(By.id("accountNumber")).click();
    driver.findElement(By.id("accountNumber")).sendKeys("46093315");
    driver.findElement(By.id("sortCode")).click();
    driver.findElement(By.id("sortCode")).sendKeys("40-42-07");
    driver.findElement(By.id("bankAccountNumber")).sendKeys("99887654");
    driver.findElement(By.id("initialAdvanceAmount")).sendKeys("£32,475.00");
    driver.findElement(By.id("lastPaymentDate")).sendKeys("26-02-2019");
    driver.findElement(By.id("lastPaymentAmount")).sendKeys("£215.03");
    //driver.findElement(By.id("verificationNext")).click();
    return this;
  }
}
