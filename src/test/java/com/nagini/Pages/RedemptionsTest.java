package com.nagini.Pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RedemptionsTest extends BaseTestClass {

  Redemptions redemptions = Redemptions.getRedemptions();

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser( testData.getEmail(), testData.getPassword(), testData.getCode() );
  }

  @Test
  public void testRedemptions() throws InterruptedException {
    redemptions.act()
      .clickRedemptionsLink()
      .checkIfRequestMadeRecentlyAndReset();

   // redemptions.verify()
   //   .requestSentMessage();

  }
}
