package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class AccountSummaryActionsController {

  private WebDriver driver = getChromeDriver();
  private WebDriverWait wait = getWebDriverWait();

  public AccountSummaryActionsController clickDownloadFile(File file) throws InterruptedException {
       if (file.exists())
      file.delete();
    // Start downloading here.
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#downloadButton")));
    driver.findElement(By.cssSelector("#downloadButton")).click();
    wait.until((ExpectedCondition<Boolean>) webDriver -> file.exists());
    return this;
  }

  public AccountSummaryActionsController filterByDate(String startDate, String endDate) throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateButton")));
    driver.findElement(By.id("dateButton")).click();
    driver.findElement(By.id("fromDate")).sendKeys(startDate);
    driver.findElement(By.id("toDate")).sendKeys(endDate);
    driver.findElement(By.id("filterButton")).click();
    return this;
  }

  public AccountSummaryActionsController removeFilter() throws InterruptedException {
    Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("removeFilterButton")));
    driver.findElement(By.id("removeFilterButton")).click();
    return this;
  }

  public AccountSummaryActionsController filterByTypeTransactions() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeButton")));
    driver.findElement(By.id("typeButton")).click();
    driver.findElement(By.id("transactions")).click();
    return this;
  }

  public AccountSummaryActionsController filterByTypeArrears() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeButton")));
    driver.findElement(By.id("typeButton")).click();
    driver.findElement(By.id("interestBearingArrears")).click();
    return this;
  }

  public AccountSummaryActionsController materialControlsNext() throws InterruptedException {
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-paginator-navigation-next")));
    driver.findElement(By.cssSelector(".mat-paginator-navigation-next")).click();
    return this;
  }
  public AccountSummaryActionsController materialControlsPrevious() throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".mat-paginator-navigation-previous")).click();
    return this;
  }

  public AccountSummaryActionsController materialControlsLast() throws InterruptedException {

    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".mat-paginator-navigation-last")).click();
    return this;
  }

  public AccountSummaryActionsController materialControlsFirst() throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".mat-paginator-navigation-first")).click();
    return this;
  }

  public AccountSummaryActionsController materialControlsDropDown() throws InterruptedException {
    Thread.sleep(1000);
    driver.findElement(By.cssSelector(".mat-select-arrow")).click();
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-option-7\"]")));
    driver.findElement(By.xpath("//*[@id=\"mat-option-7\"]")).click();
    return this;
  }


}
