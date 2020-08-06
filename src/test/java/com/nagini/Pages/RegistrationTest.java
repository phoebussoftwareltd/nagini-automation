package com.nagini.Pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class RegistrationTest extends BaseTestClass {

  LandingPage landingPage = LandingPage.getLandingPage();
  RegisterProfile registerProfile = RegisterProfile.getRegisterProfile();
  AccountSummary accountSummary = AccountSummary.getAccountSummary();

  @BeforeClass
  public void startUpBrowser() {
  driver = getChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  wait = getWebDriverWait();

  testData = new TestData.Builder()
    .setEmail("veloen4@googlemail.com")
      .setPassword("String1*")
      .setCode("code1234")
      .setFromTransactionDate("28-04-2018")
      .setToTransactionDate("30-05-2018")
      .setPaymentDate("20/02/2020")
      .setBalance("£21,756.90")
      .setInterest("8.05%")
      .setInstalment("£229.09")
      .build();
}


  @Test
  public void testRegistrationFlowIsSuccessful() throws InterruptedException {

    landingPage.act()
      .clickOnRegisterButton();

    registerProfile.act()
      .fillInProfileDetails()
      .enterMortgageAddressPostcode()
      .enterSecurityDetails()
      .enterPhoebusAccountDetails();

  //  accountSummary.verify()
  //    .accountSummaryPageIsDisplayed();


  }

}
