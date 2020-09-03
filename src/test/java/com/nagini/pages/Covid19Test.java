package com.nagini.pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Covid19Test extends BaseTestClass {

  Covid19 covid19 = Covid19.getCovid19();

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser( testData.getEmail(), testData.getPassword(), testData.getCode() );
  }

  @Test
  public void testCovid19() throws InterruptedException {
    covid19.act()
      .clickCovid19Link()
      .enterDetailsForPaymentHolidayCallBack()
      .clickRequestPaymentHoliday();


    covid19.verify()
      .requestAcknowledged();
  }


}
