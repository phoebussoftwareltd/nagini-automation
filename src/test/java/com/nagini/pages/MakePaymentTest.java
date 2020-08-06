package com.nagini.pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MakePaymentTest extends BaseTestClass {


  MakePayment makePaymentPage = MakePayment.getMakePayment();

  @BeforeMethod
  public void goToHome() {
    login.act()
      .loginUser(testData.getEmail(), testData.getPassword(), testData.getCode());
  }

  @Test
  public void testMethodOfPaymentPageIsDisplayedFromSideBar()  {

    makePaymentPage.act()
      .clickOnMakePaymentLink();

    makePaymentPage.verify()
      .makePaymentIsDisplayed();
  }


}

