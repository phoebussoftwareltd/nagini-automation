package com.nagini.pages;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.text.ParseException;

public class AccountSummaryTest extends BaseTestClass {

  AccountSummary accountSummary = AccountSummary.getAccountSummary();

  private final static int TOTAL_NUMBER_OF_TRANSACTIONS = 71;
  private static final int EXPECTED_ROWS_IN_DATE_FILTER = 14;
  private static final int EXPECTED_ROWS_IN_TRANSACTION_TYPE_FILTER = 41;
  private static final int EXPECTED_ROWS_IN_ARREARS_TYPE_FILTER = 0;

  File file = null;

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser(testData.getEmail(), testData.getPassword(), testData.getCode());
  }

  @Test
  public void testTransactionFileCreated() throws InterruptedException {

    String home = System.getProperty("user.home");
    String downloadPath = home + "/Downloads/";
    File file = new File(downloadPath + "transactions.csv");

    int initialTransactions = accountSummary.get().getNumRowsInFilter();

    accountSummary.act()
      .clickDownloadFile(file);

    accountSummary.verify()
      .transactionFileIsCreated(downloadPath, "transactions.csv");
  }

  @Test
  public void testFilterByDate() throws InterruptedException, ParseException {

    int initialTransactions = accountSummary.get().getNumRowsInFilter();

    accountSummary.act()
         .filterByDate(testData.getFromTransactionDate(), testData.getToTransactionDate());

    int filteredTransactions = accountSummary.get().getNumRowsInFilter();

    Assert.assertEquals(initialTransactions, TOTAL_NUMBER_OF_TRANSACTIONS);
    Assert.assertEquals(filteredTransactions, EXPECTED_ROWS_IN_DATE_FILTER);

    accountSummary.verify()
      .filteredDatesAreWithinRange(testData.getFromTransactionDate(), testData.getToTransactionDate());

    accountSummary.act().removeFilter();
    Assert.assertEquals(initialTransactions, TOTAL_NUMBER_OF_TRANSACTIONS);

  }

  @Test
  public void testFilterByTransactionType() throws InterruptedException {

    int initialTransactions = accountSummary.get().getNumRowsInFilter();

    accountSummary.act()
      .filterByTypeTransactions();

    int filteredTransactions = accountSummary.get().getNumRowsInFilter();

    Assert.assertEquals(filteredTransactions, EXPECTED_ROWS_IN_TRANSACTION_TYPE_FILTER);
  }

  @Test
  public void testFilterByTransactionArrears() throws InterruptedException {

    int initialTransactions = accountSummary.get().getNumRowsInFilter();

    accountSummary.act()
      .filterByTypeArrears();

    int filteredTransactions = accountSummary.get().getNumRowsInFilter();

    Assert.assertEquals(filteredTransactions, EXPECTED_ROWS_IN_ARREARS_TYPE_FILTER);

    accountSummary.act()
      .removeFilter();
  }

  @Test
  public void  testTransactionTableControls() throws InterruptedException {

    accountSummary.act()
      .removeFilter()
      .materialControlsNext();

    Thread.sleep(1000);
    String controlsText = accountSummary.get().getMaterialLabelText();
    Assert.assertEquals(controlsText,"11 - 20 of 71");

    accountSummary.act().materialControlsLast();
    Thread.sleep(1000);
    controlsText = accountSummary.get().getMaterialLabelText();
    Assert.assertEquals(controlsText,"71 - 71 of 71");

    accountSummary.act().materialControlsPrevious();
    Thread.sleep(1000);
    controlsText = accountSummary.get().getMaterialLabelText();
    Assert.assertEquals(controlsText,"61 - 70 of 71");


    accountSummary.act().materialControlsFirst();
    Thread.sleep(1000);
    controlsText = accountSummary.get().getMaterialLabelText();
    Assert.assertEquals(controlsText,"1 - 10 of 71");
  }

}
