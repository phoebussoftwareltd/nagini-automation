package com.nagini.Pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyManagePaymentDetailsPage extends BaseTestClass {

  ManagePaymentDetails managePaymentDetails = ManagePaymentDetails.getManagePaymentDetails();

  @BeforeMethod
  public void goToHome() {
    login.act()
      .loginUser( testData.getEmail(), testData.getPassword(), testData.getCode() );
  }

  @Test
  public void testMonthlyPaymentAmountIsDisplayed() throws InterruptedException {
    managePaymentDetails.act()
      .clickOnManagePaymentDetails();

    managePaymentDetails.verify()
      .managePaymentDetailsIsDisplayed();
  }

  @Test
  public void testResetMonthlyPayment() throws InterruptedException {
    managePaymentDetails.act()
      .clickOnManagePaymentDetails()
      .enterNewMonthlyPayment();

    managePaymentDetails.verify()
      .repaymentMethodMessageAcknowledged();

  }

  @Test
  public void testUpdatePaymentDate() throws InterruptedException {
    managePaymentDetails.act()
      .clickOnManagePaymentDetails()
      .clickPaymentDateTab()
      .enterNewPaymentDay()
      .clickRequestDateChange();

    managePaymentDetails.verify()
      .repaymentDateMessageAcknowledged();
  }

  @Test
  public void testDirectDebitDetails() throws InterruptedException {
    managePaymentDetails.act()
      .clickOnManagePaymentDetails()
      .clickDirectDebitTab();

    managePaymentDetails.verify()
      .directDebitDetails();
  }
}


