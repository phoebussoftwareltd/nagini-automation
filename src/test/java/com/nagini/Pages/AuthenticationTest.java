package com.nagini.Pages;

import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTestClass {

  Authentication authentication = Authentication.getAuthentication();
  Login login = Login.getLogin();


  @Test
  public void testLogonSuccessLandsOnAccountSummaryDetails() throws InterruptedException {
    login.act()
      .loginUserWithEmailPassword(testData.getEmail(), testData.getPassword());

    authentication.verify().verifyAuthenticationPageIsDisplayed();

    authentication.act()
      .enterCode(testData.getCode())
      .clickOnVerifyButton()
      .passControlToAccountSummary()
      .verify()
      .accountSummaryPageIsDisplayed();
  }

  @Test
  public void testResetPassword() {

    login.act()
      .clickResetPassword()
      .enterEmail(testData.getEmail())
      .answerSecurityQuestion(testData.getSecurityAnswer())
      .enterCode(testData.getCode())
      .enterNewPassword(testData.getNewPassword());


     login.verify()
       .userForcedToLogin();
  }

  @Test
  public void testRegisterNow() {
    login.act()
      .clickRegisterNow();

    login.verify()
      .registerProfileIsDisplayed();


  }
}
