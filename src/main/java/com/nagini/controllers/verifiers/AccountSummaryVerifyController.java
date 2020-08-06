package com.nagini.controllers.verifiers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountSummaryVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public AccountSummaryVerifyController accountSummaryPageIsDisplayed() {

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountDetails")));
    assertTrue(driver.findElement(By.id("accountDetails")).isDisplayed());

    return this;
  }

  public AccountSummaryVerifyController transactionFileIsCreated(String downloadPath,String file) {
    Assert.assertTrue((isFileDownloaded(downloadPath,file)),"Failed to download Expected document");

    return this;
  }

  public boolean isFileDownloaded(String downloadPath, String fileName) {
    boolean flag = false;
    File dir = new File(downloadPath);
    File[] dir_contents = dir.listFiles();

    for (File dir_content : dir_contents) {
      if (dir_content.getName().equals( fileName ))
        return flag = true;
    }

    return flag;
  }

  public AccountSummaryVerifyController filteredDatesAreWithinRange(String fromTransactionDate, String toTransactionDate)
    throws InterruptedException, ParseException {

    int matchingDates = 0;
    LocalDate localDate = null;
    DateTimeFormatter formatter = null;
    DateTimeFormatter fmt2 = null;

    // Converting 'dd-MMM-yyyy' String format to LocalDate
    formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate fDate = LocalDate.parse(fromTransactionDate, formatter);
    LocalDate tDate = LocalDate.parse(toTransactionDate, formatter);

    //To locate table rows in account summary.
    Thread.sleep(2000);
    List<WebElement> transactions = driver.findElements(By.xpath("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-account-details/div/app-transactions/div/table/tbody/tr/td[1]"));

    List<String> transactionDates =  transactions.stream()
      .map(WebElement::getText)
      .collect(toList());

    fmt2 = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    for (int i = 0; i < transactionDates.size(); i++) {
      LocalDate date = LocalDate.parse(transactionDates.get(i),fmt2);
      boolean result = comp_Dates(date,fDate,tDate);

      if (result) {
        matchingDates++;
      }
    }

    assertEquals( matchingDates, transactionDates.size() );

    return this;
  }

  private boolean comp_Dates(LocalDate date, LocalDate fDate, LocalDate tDate) {

    return date.compareTo( fDate ) >= 0 && date.compareTo( tDate ) <= 0;
  }
}
