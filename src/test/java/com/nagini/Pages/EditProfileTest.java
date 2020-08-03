package com.nagini.Pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditProfileTest extends BaseTestClass {

  EditProfile editProfile = EditProfile.getEditProfile();
  Login login = Login.getLogin();
  AccountSummary accountSummary = AccountSummary.getAccountSummary();

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser(testData.getEmail(), testData.getPassword(), testData.getCode());
  }

  @Test
  public void testEditProfileIsDisplayed() throws InterruptedException {
    editProfile.act()
      .clickEditProfile()
      .changePassword()
      .answerSecurityQuestion()
      .authenticateByCode()
      .closeEditProfile()
      .logout();

    login.act()
      .loginUser(testData.getEmail(), testData.getNewPassword(), testData.getCode());

    accountSummary.verify()
      .accountSummaryPageIsDisplayed();
  }
}
