package com.nagini.Pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RepaymentCalculatorTest extends BaseTestClass {

  RepaymentCalculator repaymentCalculator = RepaymentCalculator.getRepaymentCalculator();

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser( testData.getEmail(), testData.getPassword(), testData.getCode() );
  }

  @Test
  public void testRecalculatorPage() throws InterruptedException {
    repaymentCalculator.act()
      .clickRepaymentCalculatorLink()
      .selectSinglePaymentTab()
      .selectUseSlider()
      .useSliderOption();

    repaymentCalculator.verify()
      .newRepaymentTerm();
  }


  @Test
  public void testManualAdjustment() throws InterruptedException {
    repaymentCalculator.act()
      .clickRepaymentCalculatorLink()
      .selectSinglePaymentTab()
      .enterManualOptionOnSinglePaymentsTab();

    repaymentCalculator.verify()
      .newRepaymentTerm();
  }

  @Test
  public void testEditMonthlyPaymentOnRecurringTab() throws InterruptedException {
//    repaymentCalculator.act()
//      .clickRepaymentCalculatorLink()
//      .selectRecurringPaymentTab()
//      .clickOnEditMonthlyPayment();

   // repaymentCalculator.verify()
   //   .newRepaymentTerm();
  }

  @Test
  public void testRedemptionRequest() throws InterruptedException {
    repaymentCalculator.act()
      .clickRepaymentCalculatorLink()
      .RequestRedemptionTab()
      .checkIfRequestMadeRecentlyAndReset()
      .clickOnRedemptionRequest();

     repaymentCalculator.verify()
      .requestSentMessage();
  }

  @Test
  public void testMakePaymentOption() throws InterruptedException {
//        repaymentCalculator.act()
//          .clickRepaymentCalculatorLink()
//          .selectSinglePaymentTab()
//          .clickMakePayment();
//
//        repaymentCalculator.verify()
//          .paymentDetailsAreDisplayed();
//
//        repaymentCalculator.act()
//          .closeMakePaymentForm();
  }
}
