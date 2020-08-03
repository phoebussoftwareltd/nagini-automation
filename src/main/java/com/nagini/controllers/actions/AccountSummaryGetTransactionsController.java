package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;
import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertTrue;

public class AccountSummaryGetTransactionsController {

  private WebDriver driver = getChromeDriver();
  private WebDriverWait wait = getWebDriverWait();

  public List<String> transactions() throws InterruptedException {
    Thread.sleep(1000);
    List<WebElement> transactions = driver.findElements(By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-account-details/div/app-transactions/div/table/tbody/tr/td/[1]"));
    Thread.sleep(2000);
    assertTrue(transactions.size() != 0, "List is empty, failed to collect transactions");

    return transactions.stream()
      .map(WebElement::getText)
      .collect(toList());
  }

  public int getNumRowsInFilter() throws InterruptedException {
    String rowsReturned = getMaterialLabelText();
    Pattern p = Pattern.compile("-?\\d+");
    List<String> numbers = new ArrayList<String>();
    Matcher m = p.matcher(rowsReturned);
    while (m.find()) {
      numbers.add(m.group());
    }
    // text returned is 1 - 10 of 32 therefore list will provide [1,10,32] we need position 2;
    if (numbers.size() > 2) {
      return Integer.parseInt(numbers.get(2));
    } else
    return Integer.parseInt(numbers.get(1));
  }

  public String getMaterialLabelText() throws InterruptedException {
    Thread.sleep(2000);
    return driver.findElement(By.xpath(
      "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[2]/app-account-details/div/app-transactions/div/mat-paginator/div/div/div[2]/div")).getText();

  }


}
